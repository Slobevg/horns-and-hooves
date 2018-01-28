package com.slobevg.hornsandhooves.service;

import com.slobevg.hornsandhooves.model.Department;
import com.slobevg.hornsandhooves.model.DepartmentType;
import com.slobevg.hornsandhooves.model.FurnitureType;
import com.slobevg.hornsandhooves.model.Order;
import com.slobevg.hornsandhooves.repository.DepartmentRepository;
import com.slobevg.hornsandhooves.repository.OrderRepository;
import com.slobevg.hornsandhooves.repository.OrderSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, DepartmentRepository departmentRepository) {
        this.orderRepository = orderRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void save(Order order) {
        FurnitureType furnitureType = order.getFurnitureType();
        DepartmentType departmentType = Arrays.stream(DepartmentType.values())
                .filter(type -> type.getFurnitureTypes().contains(furnitureType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Furniture not supported: " + furnitureType));
        Department department = departmentRepository.findByDepartmentType(departmentType);
        order.setDepartment(department);
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> list(OrderFilter orderFilter) {
        Specification<Order> specification = OrderSpecifications.from(orderFilter);
        return orderRepository.findAll(specification);
    }

    @Transactional
    public void delete(Order order) {
        orderRepository.delete(order);
    }
}
