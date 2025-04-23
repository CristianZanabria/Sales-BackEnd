package com.zdevs.security;

//Class S2

import com.zdevs.model.User;
import com.zdevs.repo.IUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private  final IUserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findOneByUsername(username);

        if(user == null){
            throw  new UsernameNotFoundException("user not found");
        }
        List<GrantedAuthority> roles  = new ArrayList<>();
        String role = user.getRole().getName();
        roles.add(new SimpleGrantedAuthority(role));

        return  new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), roles);
    }
}
