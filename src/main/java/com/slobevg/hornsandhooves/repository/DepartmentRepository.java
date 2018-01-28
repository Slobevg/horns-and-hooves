package com.slobevg.hornsandhooves.repository;

import com.slobevg.hornsandhooves.model.Department;
import com.slobevg.hornsandhooves.model.DepartmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentType(DepartmentType departmentType);
}
