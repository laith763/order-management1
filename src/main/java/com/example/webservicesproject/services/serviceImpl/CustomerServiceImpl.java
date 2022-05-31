package com.example.webservicesproject.services.serviceImpl;

import com.example.webservicesproject.dto.CustomerDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.mappers.CustomerMapper;
import com.example.webservicesproject.models.Customer;
import com.example.webservicesproject.repositories.CustomerRepository;
import com.example.webservicesproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAllCustomer(){
        List <Customer> customerList = customerRepository.findAll();
        if(customerList.size() == 0) throw new ApiRequestException("No Customers in the system");
        return customerMapper.convertListCustomerToDto(customerList);
    }

    @Override
    public CustomerDto getCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The customer that has id %s not found",id)));
        return customerMapper.convertCustomerToDto(customer);
    }

    @Override
    public void addCustomer(Customer customer) throws ApiRequestException {
        boolean isCustomerAlreadyExists = customerRepository.findById(customer.getCustomerId()).isPresent();
        if(isCustomerAlreadyExists) throw new ApiRequestException("There is no two Customers should have the same id");
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) throws ApiRequestException {
        boolean isCustomerExists = customerRepository.findById(id).isPresent();
        if(!isCustomerExists) throw new ApiRequestException("The Customer you are trying to update does not exist");
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) throws ApiRequestException {
        boolean isCustomerExists = customerRepository.findById(id).isPresent();
        if(!isCustomerExists) throw new ApiRequestException("The Customer you are trying to delete does not exist");
        customerRepository.deleteById(id);
    }
}
