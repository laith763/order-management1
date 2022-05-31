package com.example.webservicesproject.services.serviceImpl;

import com.example.webservicesproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyCustomerDetailsService implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return customerRepository.findByCustomerName(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Customer %s not found", username)));
    }
}
