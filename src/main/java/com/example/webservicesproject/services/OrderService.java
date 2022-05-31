package com.example.webservicesproject.services;

import com.example.webservicesproject.dto.OrderDto;
import com.example.webservicesproject.models.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrder();

    OrderDto getOrder(Long id) ;

    void addOrder(Order Order) ;

    void updateOrder(Long id, Order Order) ;

    void deleteOrder(Long id) ;
}
