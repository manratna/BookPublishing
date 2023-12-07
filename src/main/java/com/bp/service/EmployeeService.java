package com.bp.service;

import java.util.List;

import com.bp.model.EmployeeDTO;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    List<EmployeeDTO> getEmployeesById(Long id);

    List<EmployeeDTO> getEmployeesByPubId(Long pubId);

    List<EmployeeDTO> getEmployeesByFirstName(String firstName);

    List<EmployeeDTO> getEmployeesByLastName(String lastName);

    List<EmployeeDTO> getEmployeesByHireDate(String hireDate);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO employeeDTO);
}
