package com.zdevs.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Clase S3
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {

    private String username;
    private String password;
}

