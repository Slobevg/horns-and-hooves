package com.slobevg.hornsandhooves.controller;

import com.slobevg.hornsandhooves.model.Order;
import com.slobevg.hornsandhooves.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public void create(@RequestBody Order order) {
    }

    public List<Order> list() {
        return null;
    }

    public void update(@RequestBody Order order) {

    }

    public void delete(@RequestParam Long id) {

    }
}
