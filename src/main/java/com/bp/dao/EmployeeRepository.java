package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByPublisherId(Long pubId);

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByHireDate(String hireDate);

    // Additional custom queries can be added here if needed
}
