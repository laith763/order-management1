package com.example.webservicesproject.services;

import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.AuthenticationRequest;
import com.example.webservicesproject.models.AuthenticationResponse;

public interface LoginService {
    AuthenticationResponse logIn(AuthenticationRequest authenticationRequest) throws ApiRequestException;

}
