package com.example.webservicesproject.controllers;


import com.example.webservicesproject.constants.PathConstants;
import com.example.webservicesproject.dto.OrderDto;
import com.example.webservicesproject.exception.ApiRequestException;
import com.example.webservicesproject.models.Order;
import com.example.webservicesproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Order.RESOURSE_BASE_V0)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getAllOrder() throws ApiRequestException {
        return orderService.getAllOrder();
    }

    @GetMapping(PathConstants.ID)
    public OrderDto getOrder(@PathVariable Long id) throws ApiRequestException{
        return orderService.getOrder(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) throws ApiRequestException{
        orderService.addOrder(order);
    }

    @PatchMapping(PathConstants.ID)
    public void updateOrder(@PathVariable Long id,@RequestBody Order order) throws ApiRequestException{
        orderService.updateOrder(id, order);
    }
    @DeleteMapping(PathConstants.ID)
    public void deleteOrder(@PathVariable Long id) throws ApiRequestException{
        orderService.deleteOrder(id);
    }

}
