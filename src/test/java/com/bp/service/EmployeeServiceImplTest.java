package com.bp.service;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.bp.dao.EmployeeRepository;
import com.bp.dao.entity.Employee;
import com.bp.dao.entity.Job;
import com.bp.dao.entity.Publisher;
import com.bp.exception.NoEmployeeDataAvailableException;
import com.bp.model.EmployeeDTO;
 
	@SpringBootTest
	public class EmployeeServiceImplTest {
		@Mock
		private EmployeeRepository  employeeRepository;
		@InjectMocks
		private EmployeeServiceImpl employeeServiceImpl;
		private List<Employee> createSampleEmployeeDTO() {
	        List<Employee>employees = new ArrayList<>();
	        Employee employee1 = new Employee();
	        employee1.setId(1L);
	        employee1.setFirstName("Nalla");
	        employee1.setMiddleInitial("Chaitra");
	        employee1.setLastName("Reddy");
	        employee1.setHireDate("23-09-2019");
	        Publisher publisher1 = new Publisher();
	        publisher1.setId(63L);
	        publisher1.setName("Boston");
	        employee1.setPublisher(publisher1);
	        Job jobs1 = new Job();
	        jobs1.setId(70L);
	       jobs1.setDescription("Trainee");
	       jobs1.setMinLevel(1);
	       jobs1.setMaxLevel(90);
	       employee1.setJob(jobs1);
	       employees.add(employee1);
	       Employee employee2 = new Employee();
	       employee2.setId(2L);
	       employee2.setFirstName("Kusa");
	       employee2.setMiddleInitial("Ramya");
	       employee2.setLastName("Reddy");
	       employee2.setHireDate("23-09-2018");
	       Publisher publisher2 = new Publisher();
	       publisher2.setId(64L);
	       publisher2.setName("Boston");
	       employee2.setPublisher(publisher1);
	       Job jobs2 = new Job();
	       jobs2.setId(71L);
	      jobs2.setDescription("Analyst");
	      jobs2.setMinLevel(2);
	      jobs2.setMaxLevel(91);
	      employee2.setJob(jobs2);
	      employees.add(employee2);
	      Employee employee3 = new Employee();
	      employee3.setId(3L);
	      employee3.setFirstName("aaa");
	      employee3.setMiddleInitial("bbb");
	      employee3.setLastName("ccc");
	      employee3.setHireDate("23-08-2019");
	      Publisher publisher3 = new Publisher();
	      publisher3.setId(64L);
	      publisher3.setName("Washington");
	      employee3.setPublisher(publisher2);
	      Job jobs3 = new Job();
	      jobs3.setId(72L);
	     jobs3.setDescription("Engineer");
	     jobs3.setMinLevel(3);
	     jobs3.setMaxLevel(93);
	     employee1.setJob(jobs3);
	     employees.add(employee3);

	     Employee employee4 = new Employee();
	     employee4.setId(1L);
	     employee4.setFirstName("XX");
	     employee4.setMiddleInitial("YYY");
	     employee4.setLastName("zzz");
	     employee4.setHireDate("12-06-2017");
	     Publisher publisher4 = new Publisher();
	     publisher4.setId(65L);
	     publisher4.setName("Berkely");
	     employee4.setPublisher(publisher3);
	     Job jobs4 = new Job();
	     jobs4.setId(73L);
	    jobs4.setDescription("Associate");
	    jobs4.setMinLevel(4);
	    jobs4.setMaxLevel(93);
	    employee4.setJob(jobs4);
	    employees.add(employee4);
	    Employee employee5 = new Employee();
	    employee5.setId(1L);
	    employee5.setFirstName("qqq");
	    employee5.setMiddleInitial("rrr");
	    employee5.setLastName("ssss");
	    employee5.setHireDate("23-05-2018");
	    Publisher publisher5 = new Publisher();
	    publisher5.setId(66L);
	    publisher5.setName("Uk");
	    employee5.setPublisher(publisher5);
	    Job jobs5 = new Job();
	    jobs5.setId(70L);
	   jobs5.setDescription("associate analyst");
	   jobs5.setMinLevel(5);
	   jobs5.setMaxLevel(94);
	   employee1.setJob(jobs5);
	   employees.add(employee5);
	   Employee employee6 = new Employee();
	   employee6.setId(6L);
	   employee6.setFirstName("eeee");
	   employee6.setMiddleInitial("ffff");
	   employee6.setLastName("ggg");
	   employee6.setHireDate("12-02-2016");
	   Publisher publisher6 = new Publisher();
	   publisher6.setId(66L);
	   publisher6.setName("France");
	   employee6.setPublisher(publisher6);
	   Job jobs6 = new Job();
	   jobs6.setId(70L);
	  jobs6.setDescription("Manager");
	  jobs6.setMinLevel(6);
	  jobs6.setMaxLevel(95);
	  employee1.setJob(jobs1);
	  employees.add(employee6);
	  return employees;
		}

	 @Test  
	  	void testGetAllEmployees() {       
		  List<Employee> employees = createSampleEmployeeDTO();    
		  when(employeeRepository.findAll()).thenReturn(createSampleEmployeeDTO());  
		  List<EmployeeDTO> result = employeeServiceImpl.getAllEmployees();       
		  assertNotNull(result);        
		  assertEquals(employees.size(), result.size());        
		  assertEquals(result.get(0).getId(), employees.get(0).getId());        
		  assertEquals(result.get(0).getFirstName(), employees.get(0).getFirstName());         
	  }
	 @Test
	 void testGetEmployeesById() {
	     Long employeeId = 1L;
	     List<Employee> employees = createSampleEmployeeDTO();
	     when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employees.get(0)));
	     List<EmployeeDTO> result = employeeServiceImpl.getEmployeesById(employeeId);
	     assertNotNull(result);
	     assertEquals(1, result.size());
	     assertEquals(employees.get(0).getFirstName(), result.get(0).getFirstName());
	     verify(employeeRepository).findById(employeeId);
	 }

	 @Test
	 void testGetEmployeesByPubIdException() {
	     Long pubId = 1L;
	     List<Employee> expectedEmployees = createSampleEmployeeDTO();
	     when(employeeRepository.findByPublisherId(pubId)).thenReturn(
	             expectedEmployees);
	     List<EmployeeDTO> result = employeeServiceImpl.getEmployeesByPubId(pubId);
	     assertNotNull(result);
	     assertEquals(expectedEmployees.size(), result.size());
	    }

	 @Test
	 void testGetEmployeesByFirstNameException() {
	    String firstNameToSearch = "John"; // Replace with an actual first name
	     List<Employee> expectedEmployees = createSampleEmployeeDTO();
	     when(employeeRepository.findByFirstName(firstNameToSearch)).thenReturn(expectedEmployees);
	     String exception="No Employee Data Available";
         assertThrows(NoEmployeeDataAvailableException.class,
	             () -> employeeServiceImpl.getEmployeesByFirstName(exception));
	 }

	 @Test
	 void testGetEmployeesByLastNameException() {
	     String lastNameToSearch = "Monday"; 
	     when(employeeRepository.findByLastName(lastNameToSearch)).thenReturn(Collections.emptyList());
         assertThrows(NoEmployeeDataAvailableException.class,
	             () -> employeeServiceImpl.getEmployeesByLastName(lastNameToSearch));
	 }

	 @Test
	 void testGetEmployeesByHireDate() {
	     String hireDateToSearch = "23-09-2019";
	     List<Employee> expectedEmployees = createSampleEmployeeDTO().subList(0, 1);
	     when(employeeRepository.findByHireDate(hireDateToSearch)).thenReturn(expectedEmployees);
	     List<EmployeeDTO> result = employeeServiceImpl.getEmployeesByHireDate(hireDateToSearch);
	     assertNotNull(result);
	     assertEquals(expectedEmployees.size(), result.size());
	     verify(employeeRepository).findByHireDate(hireDateToSearch);
	 }
 
	 @Test
	 void testGetEmployeesByHireDate_NoEmployeeDataAvailable() {
	     String hireDateToSearch = "23-09-2022";
	     when(employeeRepository.findByHireDate(hireDateToSearch)).thenReturn(Collections.emptyList());
	     assertThrows(NoEmployeeDataAvailableException.class,
	             () -> employeeServiceImpl.getEmployeesByHireDate(hireDateToSearch));
 
	     
	     verify(employeeRepository).findByHireDate(hireDateToSearch);
	 }
	 @Test
	 void testUpdateEmployee() throws NoEmployeeDataAvailableException {
	     Long employeeId = 1L;
	     EmployeeDTO updatedEmployeeDTO = new EmployeeDTO();  
	     Optional<Employee> existingEmployeeOptional = Optional.of(new Employee());
	     when(employeeRepository.findById(employeeId)).thenReturn(existingEmployeeOptional);
	     EmployeeDTO result = employeeServiceImpl.updateEmployee(employeeId, updatedEmployeeDTO);
	     assertNotNull(result);
	     verify(employeeRepository).findById(employeeId);
	     verify(employeeRepository).save(any(Employee.class)); 
	 }
}