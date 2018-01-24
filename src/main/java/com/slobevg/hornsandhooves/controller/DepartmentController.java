package com.slobevg.hornsandhooves.controller;

import com.slobevg.hornsandhooves.model.Department;
import com.slobevg.hornsandhooves.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void create(@RequestBody Department department) {
    }

    public List<Department> list() {
        return null;
    }

    public void update(@RequestBody Department department) {

    }

    public void delete(@RequestParam Long id) {

    }
}
