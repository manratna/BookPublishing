package com.bp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.EmployeeRepository;
import com.bp.dao.entity.Employee;
import com.bp.dao.entity.Job;
import com.bp.dao.entity.Publisher;
import com.bp.model.EmployeeDTO;
import com.bp.model.JobDTO;
import com.bp.model.PublisherDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeRepository employeeRepository;

 @Override
 public String addEmployee(EmployeeDTO employeeDTO) {
     Employee employee = new Employee();
     try {
    	 employee = copyProperties(employeeDTO, employee);
         employeeRepository.save(employee);
         return "Record Created Successfully";
     } catch (Exception e) {
         e.printStackTrace();
         return "Error Creating Record";
     }
 }

 @Override
 public List<EmployeeDTO> getAllEmployees() {
     return employeeRepository.findAll().stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<EmployeeDTO> getEmployeesById(Long id) {
     return employeeRepository.findById(id)
             .map(employee -> List.of(convertToDTO(employee)))
             .orElseGet(List::of);
 }

 @Override
 public List<EmployeeDTO> getEmployeesByPubId(Long pubId) {
     return employeeRepository.findByPublisherId(pubId).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<EmployeeDTO> getEmployeesByFirstName(String firstName) {
     return employeeRepository.findByFirstName(firstName).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<EmployeeDTO> getEmployeesByLastName(String lastName) {
     return employeeRepository.findByLastName(lastName).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<EmployeeDTO> getEmployeesByHireDate(String hireDate) {
     return employeeRepository.findByHireDate(hireDate).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
     Optional<Employee> employeeOptional = employeeRepository.findById(id);
     if (employeeOptional.isPresent()) {
         Employee employee = employeeOptional.get();
         try {
        	 employee = copyProperties(employeeDTO, employee);
             employeeRepository.save(employee);
             return convertToDTO(employee);
         } catch (Exception e) {
             e.printStackTrace();
             // Handle the exception as needed
         }
     }
     return null;
 }

 @Override
 public EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO employeeDTO) {
     Optional<Employee> employeeOptional = employeeRepository.findById(id);
     if (employeeOptional.isPresent()) {
         Employee employee = employeeOptional.get();
         try {
        	 employee = copyProperties(employeeDTO, employee);
             employeeRepository.save(employee);
             return convertToDTO(employee);
         } catch (Exception e) {
             e.printStackTrace();
             // Handle the exception as needed
         }
     }
     return null;
 }

 private EmployeeDTO convertToDTO(Employee employee) {
     EmployeeDTO employeeDTO = new EmployeeDTO();
     employeeDTO = copyProperties(employee, employeeDTO);
     return employeeDTO;
 }

 private Employee copyProperties(EmployeeDTO source, Employee target) {
     BeanUtils.copyProperties(source, target);
     Job job = new Job();
     Publisher publisher = new Publisher();
     BeanUtils.copyProperties(source.getJob(), job);
     BeanUtils.copyProperties(source.getPublisher(), publisher);
     target.setPublisher(publisher);
     target.setJob(job);
     return target;
 }

 private EmployeeDTO copyProperties(Employee source, EmployeeDTO target) {
     BeanUtils.copyProperties(source, target);
     JobDTO jobDTO = new JobDTO();
     PublisherDTO publisherDTO = new PublisherDTO();
     BeanUtils.copyProperties(source.getJob(), jobDTO);
     BeanUtils.copyProperties(source.getPublisher(), publisherDTO);
     target.setPublisher(publisherDTO);
     target.setJob(jobDTO);
     return target;
 }
}
