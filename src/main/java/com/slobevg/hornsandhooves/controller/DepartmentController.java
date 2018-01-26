package com.slobevg.hornsandhooves.controller;

import com.slobevg.hornsandhooves.model.Department;
import com.slobevg.hornsandhooves.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public void create(@RequestBody Department department) {
        departmentService.save(department);
    }

    @GetMapping
    public List<Department> list() {
        return departmentService.list();
    }

    @GetMapping(path = "/{id}")
    public Department get(@PathVariable("id") Department department) {
        return department;
    }

    @PatchMapping(value = "/{id}")
    public void update(@ModelAttribute("id") Department department) {
        departmentService.save(department);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Department department) {
        departmentService.delete(department);
    }
}
