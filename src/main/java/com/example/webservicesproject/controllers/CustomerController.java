package com.example.webservicesproject.controllers;

import com.example.webservicesproject.constants.PathConstants;
import com.example.webservicesproject.dto.CustomerDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.Customer;
import com.example.webservicesproject.services.CustomerService;
import com.example.webservicesproject.constants.PathConstants;
import com.example.webservicesproject.dto.CustomerDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.Customer;
import com.example.webservicesproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Customer.RESOURSE_BASE_V0)
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public List<CustomerDto> getAllCustomer() throws ApiRequestException {
        return customerService.getAllCustomer();
    }

    @GetMapping(PathConstants.ID)
    public CustomerDto getCustomer(@PathVariable Long id) throws ApiRequestException{
        return customerService.getCustomer(id);
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) throws ApiRequestException{
        customerService.addCustomer(customer);
    }

    @PatchMapping(PathConstants.ID)
    public void updateCustomer(@PathVariable Long id,@RequestBody Customer customer) throws ApiRequestException{
        customerService.updateCustomer(id,customer);
    }

    @DeleteMapping(PathConstants.ID)
    public void deleteCustomer(@PathVariable Long id) throws ApiRequestException{
        customerService.deleteCustomer(id);
    }
}
