package com.example.webservicesproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebServicesProjectApplication {

    @Bean
    public org.modelmapper.ModelMapper modelMapper(){
        return new org.modelmapper.ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(WebServicesProjectApplication.class, args);
    }

}
