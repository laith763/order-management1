package com.example.webservicesproject.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int customerId;
    private String firstName;
    private Date bornAt;
}
