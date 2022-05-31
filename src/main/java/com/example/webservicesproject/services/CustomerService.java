package com.example.webservicesproject.services;

import com.example.webservicesproject.dto.CustomerDto;
import com.example.webservicesproject.models.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomer();

    CustomerDto getCustomer(Long id) ;

    void addCustomer(Customer Customer) ;

    void updateCustomer(Long id, Customer Customer) ;

    void deleteCustomer(Long id) ;
}
