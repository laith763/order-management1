package com.example.webservicesproject.mappers;


import com.example.webservicesproject.dto.OrderDto;
import com.example.webservicesproject.models.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    
    @Autowired
    private ModelMapper modelMapper;


    public OrderDto convertOrderToDto(Order Order){
        OrderDto OrderDto;
        OrderDto = modelMapper.map(Order, OrderDto.class);
        return OrderDto;
    }
    public List<OrderDto> convertListOrderToDto(List<Order> Order){
        return Order.stream().map(x -> convertOrderToDto(x)).collect(Collectors.toList());
    }
    public Order convertDtoToOrder(OrderDto OrderDto){
        Order Order;
        Order = modelMapper.map(OrderDto, Order.class);
        return Order;
    }
    public List<Order> convertListDtoToOrder(List<OrderDto> dto)
    {
        return dto.stream().map(x -> convertDtoToOrder(x)).collect(Collectors.toList());
    }



}

