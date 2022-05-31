package com.example.webservicesproject.services.serviceImpl;


import com.example.webservicesproject.dto.OrderDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.mappers.OrderMapper;
import com.example.webservicesproject.models.Order;
import com.example.webservicesproject.repositories.OrderRepository;
import com.example.webservicesproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderMapper orderMapper;


    @Override
    public List<OrderDto> getAllOrder(){
        List <Order> orderList = orderRepository.findAll();
        if(orderList.size() == 0) throw new ApiRequestException("No Orders in the system");
        return orderMapper.convertListOrderToDto(orderList);
    }

    @Override
    public OrderDto getOrder(Long id){
        Order order = orderRepository.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The Order that has id %s not found",id)));
        return orderMapper.convertOrderToDto(order);
    }

    @Override
    public void addOrder(Order order) throws ApiRequestException {
        boolean isOrderAlreadyExists = orderRepository.findById(order.getOrderId()).isPresent();
        if(isOrderAlreadyExists) throw new ApiRequestException("There is no two Orders should have the same id");
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(Long id, Order order) throws ApiRequestException {
        boolean isOrderExists = orderRepository.findById(id).isPresent();
        if(!isOrderExists) throw new ApiRequestException("The Order you are trying to update does not exist");
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) throws ApiRequestException {
        boolean isOrderExists = orderRepository.findById(id).isPresent();
        if(!isOrderExists) throw new ApiRequestException("The Order you are trying to delete does not exist");
        orderRepository.deleteById(id);
    }
}
