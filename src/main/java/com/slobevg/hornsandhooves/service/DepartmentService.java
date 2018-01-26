package com.slobevg.hornsandhooves.service;

import com.slobevg.hornsandhooves.model.Department;
import com.slobevg.hornsandhooves.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Transactional(readOnly = true)
    public List<Department> list() {
        return departmentRepository.findAll();
    }

    @Transactional
    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
