package com.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.EmployeeDTO;
import com.bp.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

 @Autowired
 private EmployeeService employeeService;

 @PostMapping("/post")
 public String addEmployee(@RequestBody EmployeeDTO employeeDTO) {
     return employeeService.addEmployee(employeeDTO);
 }

 @GetMapping
 public List<EmployeeDTO> getAllEmployees() {
     return employeeService.getAllEmployees();
 }

 @GetMapping("/{id}")
 public List<EmployeeDTO> getEmployeesById(@PathVariable Long id) {
     return employeeService.getEmployeesById(id);
 }

 @GetMapping("/pubid/{pubid}")
 public List<EmployeeDTO> getEmployeesByPubId(@PathVariable Long pubid) {
     return employeeService.getEmployeesByPubId(pubid);
 }

 @GetMapping("/fname/{fname}")
 public List<EmployeeDTO> getEmployeesByFirstName(@PathVariable String fname) {
     return employeeService.getEmployeesByFirstName(fname);
 }

 @GetMapping("/lname/{lname}")
 public List<EmployeeDTO> getEmployeesByLastName(@PathVariable String lname) {
     return employeeService.getEmployeesByLastName(lname);
 }

 @GetMapping("/hiredate/{hiredate}")
 public List<EmployeeDTO> getEmployeesByHireDate(@PathVariable String hiredate) {
     return employeeService.getEmployeesByHireDate(hiredate);
 }

 @PutMapping("/{id}")
 public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
     return employeeService.updateEmployee(id, employeeDTO);
 }

 @PatchMapping("/{id}")
 public EmployeeDTO partialUpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
     return employeeService.partialUpdateEmployee(id, employeeDTO);
 }
}
