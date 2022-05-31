package com.example.webservicesproject.controllers;


import com.example.webservicesproject.constants.PathConstants;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.AuthenticationRequest;
import com.example.webservicesproject.models.AuthenticationResponse;
import com.example.webservicesproject.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PathConstants.Login.RESOURSE_BASE_V0)
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public AuthenticationResponse LogIn(@RequestBody AuthenticationRequest authenticationRequest) throws ApiRequestException {
        return loginService.logIn(authenticationRequest);
    }
}
