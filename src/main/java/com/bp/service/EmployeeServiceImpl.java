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
import com.bp.exception.NoDataAvailableException;
import com.bp.exception.NoEmployeeDataAvailableException;
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
         throw new NoEmployeeDataAvailableException("Not null exception");
     }
 }

 @Override
 public List<EmployeeDTO> getAllEmployees() throws NoEmployeeDataAvailableException {
      List<EmployeeDTO> collect = employeeRepository.findAll().stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
     if (collect.isEmpty()) {
         throw new NoEmployeeDataAvailableException("No Employee Data Available");
     }
     return collect;
 }

 @Override
 public List<EmployeeDTO> getEmployeesById(Long id) throws NoEmployeeDataAvailableException{
     List<EmployeeDTO> orElseGet = employeeRepository.findById(id)
             .map(employee -> List.of(convertToDTO(employee)))
             .orElseGet(List::of);
     if (orElseGet.isEmpty()) {
         throw new NoEmployeeDataAvailableException("No Employee Data Available");
     }
	return orElseGet;
 }

 @Override
 public List<EmployeeDTO> getEmployeesByPubId(Long pubId) throws NoEmployeeDataAvailableException{
     List<EmployeeDTO> collect = employeeRepository.findByPublisherId(pubId).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
     if (collect.isEmpty()) {
         throw new NoEmployeeDataAvailableException("No Employee Data Available");
     }
	return collect;
 }

 @Override
 public List<EmployeeDTO> getEmployeesByFirstName(String firstName)throws NoEmployeeDataAvailableException {
     List<EmployeeDTO> collect = employeeRepository.findByFirstName(firstName).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
     if (collect.isEmpty()) {
         throw new NoEmployeeDataAvailableException("No Employee Data Available");
     }
	return collect;
    
 }

 @Override
 public List<EmployeeDTO> getEmployeesByLastName(String lastName)throws NoEmployeeDataAvailableException {
     List<EmployeeDTO> collect = employeeRepository.findByLastName(lastName).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
     if (collect.isEmpty()) {
         throw new NoEmployeeDataAvailableException("No Employee Data Available");
     }
	return collect;
 }

 @Override
 public List<EmployeeDTO> getEmployeesByHireDate(String hireDate) throws NoEmployeeDataAvailableException{
     List<EmployeeDTO> collect = employeeRepository.findByHireDate(hireDate).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
     if (collect.isEmpty()) {
         throw new NoEmployeeDataAvailableException("No Employee Data Available");
     }
	return collect;
 }

 @Override
 public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO)throws NoEmployeeDataAvailableException {
     Optional<Employee> employeeOptional = employeeRepository.findById(id);
     if (employeeOptional.isPresent()) {
         Employee employee = employeeOptional.get();
         try {
        	 employee = copyProperties(employeeDTO, employee);
             employeeRepository.save(employee);
             return convertToDTO(employee);
         } catch (NoEmployeeDataAvailableException e) {
        	 throw new NoEmployeeDataAvailableException("No Employee Data Available");
         }
     }
     return null;
 }

 @Override
 public EmployeeDTO partialUpdateEmployee(Long id, EmployeeDTO employeeDTO) throws NoEmployeeDataAvailableException{
     Optional<Employee> employeeOptional = employeeRepository.findById(id);
     if (employeeOptional.isPresent()) {
         Employee employee = employeeOptional.get();
         try {
        	 employee = copyProperties(employeeDTO, employee);
             employeeRepository.save(employee);
             return convertToDTO(employee);
         } catch (NoEmployeeDataAvailableException e) {
        	 throw new NoEmployeeDataAvailableException("No Employee Data Available");
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
	    if (source != null) {
	        BeanUtils.copyProperties(source, target);

	        if (source.getJob() != null) {
	            Job job = new Job();
	            BeanUtils.copyProperties(source.getJob(), job);
	            target.setJob(job);
	        }

	        if (source.getPublisher() != null) {
	            Publisher publisher = new Publisher();
	            BeanUtils.copyProperties(source.getPublisher(), publisher);
	            target.setPublisher(publisher);
	        }
	    }
	    return target;
	}


 private EmployeeDTO copyProperties(Employee source, EmployeeDTO target) {
	    if (source != null) {
	        BeanUtils.copyProperties(source, target);

	        if (source.getJob() != null) {
	            JobDTO jobDTO = new JobDTO();
	            BeanUtils.copyProperties(source.getJob(), jobDTO);
	            target.setJob(jobDTO);
	        }

	        if (source.getPublisher() != null) {
	            PublisherDTO publisherDTO = new PublisherDTO();
	            BeanUtils.copyProperties(source.getPublisher(), publisherDTO);
	            target.setPublisher(publisherDTO);
	        }
	    }
	    return target;
	}

}
