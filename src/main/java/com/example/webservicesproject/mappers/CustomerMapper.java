package com.example.webservicesproject.mappers;

import com.example.webservicesproject.dto.CustomerDto;
import com.example.webservicesproject.models.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerDto convertCustomerToDto(Customer Customer){
        CustomerDto CustomerDto;
        CustomerDto = modelMapper.map(Customer, CustomerDto.class);
        return CustomerDto;
    }
    public List<CustomerDto> convertListCustomerToDto(List<Customer> Customer){
        return Customer.stream().map(x -> convertCustomerToDto(x)).collect(Collectors.toList());
    }
    public Customer convertDtoToCustomer(CustomerDto CustomerDto){
        Customer Customer;
        Customer = modelMapper.map(CustomerDto, Customer.class);
        return Customer;
    }
    public List<Customer> convertListDtoToCustomer(List<CustomerDto> dto)
    {
        return dto.stream().map(x -> convertDtoToCustomer(x)).collect(Collectors.toList());
    }
}
