package com.example.webservicesproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
    private Date expirationTime;
    private String username;
//    private String roles;
    private Collection<?> authorities;
}
