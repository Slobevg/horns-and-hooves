package com.slobevg.hornsandhooves.controller;

import com.slobevg.hornsandhooves.model.Order;
import com.slobevg.hornsandhooves.model.Worker;
import com.slobevg.hornsandhooves.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void create(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }

    @GetMapping(path = "/{id}")
    public Order get(@PathVariable("id") Order order) {
        return order;
    }

    @PatchMapping(value = "/{id}")
    public void update(@ModelAttribute("id") Order order) {
        orderService.save(order);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Order order) {
        orderService.delete(order);
    }
}
