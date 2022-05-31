package com.example.webservicesproject.services.serviceImpl;

import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.AuthenticationRequest;
import com.example.webservicesproject.models.AuthenticationResponse;
import com.example.webservicesproject.services.LoginService;
import com.example.webservicesproject.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private MyCustomerDetailsService myCustomerDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Override
    public AuthenticationResponse logIn(AuthenticationRequest authenticationRequest) throws ApiRequestException {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new ApiRequestException("Incorrect username or password");
        }
        catch (Exception e){
            throw new ApiRequestException(e.getMessage());
        }

        final UserDetails userDetails = myCustomerDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        final Date expirationTime = jwtTokenUtil.extractExpiration(jwt);

        return new AuthenticationResponse(jwt,expirationTime, userDetails.getUsername(), userDetails.getAuthorities());
    }


}
