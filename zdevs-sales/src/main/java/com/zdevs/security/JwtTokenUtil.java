package com.zdevs.security;

//class s1

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.io.Serializable;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class JwtTokenUtil implements Serializable {

    //milisegundos
    public final  long JWT_TOKEN_VALIDITY = 5 * 60 * 60 * 1000; // 5 HOUR

    @Value("${jwt.secret}")// Expression language
    private  String secret;

    //Payload //valores internos del token //claims
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();


        claims.put("role", userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining()));
        claims.put("test", "value-test");


        return doGenerateToken(claims, userDetails.getUsername());

    }

    private String doGenerateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(getSigningKey())
                .compact();

    }

    private Key getSigningKey(){

        return  new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS512.getJcaName());

    }
    /////////////////////////////////////////Validation///////////////////
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
    }

     public <T>  T getClaimFromToken(String token, Function<Claims,T> claimsResolver) {
         final Claims claims = getAllClaimsFromToken(token);
         return claimsResolver.apply(claims);
     }
    public  String getUsernameFromToken(String token){
        return getClaimFromToken(token, Claims::getSubject);
    }
    public  Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public  boolean validateToken(String token, UserDetails userDetails){
        final  String username = getUsernameFromToken(token);
        return (username.equalsIgnoreCase(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
