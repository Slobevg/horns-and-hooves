package com.slobevg.hornsandhooves.repository;

import com.slobevg.hornsandhooves.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
