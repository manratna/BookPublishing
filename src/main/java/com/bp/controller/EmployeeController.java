package com.bp.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.EmployeeDTO;
import com.bp.service.EmployeeServiceImpl;

import jakarta.validation.Valid;
 
@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;
 
    @PostMapping("/post")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        String addNewEmployee = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(addNewEmployee, HttpStatus.OK);
    }
 
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesById(@PathVariable("id") Long id) {
        List<EmployeeDTO> employees = employeeService.getEmployeesById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
 
    @GetMapping("/pubid/{pubid}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByPubId(@PathVariable Long pubid) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByPubId(pubid);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
 
    @GetMapping("/fname/{fname}")
    public ResponseEntity<List<EmployeeDTO> >getEmployeeByFirstName(@PathVariable String fname) {
        List<EmployeeDTO> employee = employeeService.getEmployeesByFirstName(fname);
        return new ResponseEntity<>(employee, HttpStatus.OK);
        } 

 
 
    @GetMapping("/lname/{lname}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByLastName(@PathVariable String lname) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByLastName(lname);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
 
    @GetMapping("/hiredate/{hiredate}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeesByHireDate(@PathVariable String hiredate) {
        List<EmployeeDTO> employees = employeeService.getEmployeesByHireDate(hiredate);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
 
    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDTO> partialUpdateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.partialUpdateEmployee(id, employeeDTO);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
}