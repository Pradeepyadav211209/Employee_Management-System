package com.apiexample.Repository;

import com.apiexample.Entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Long> {
}