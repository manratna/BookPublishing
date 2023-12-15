package com.bp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.JobRepository;
import com.bp.dao.entity.Job;
import com.bp.dao.entity.Store;
import com.bp.exception.NoDataAvailableException;
import com.bp.model.JobDTO;
@SpringBootTest
class JobServiceImplTest {
	
	@Mock
    private JobRepository jobRepository;

    @InjectMocks
    private JobServiceImpl jobServiceImpl;
    
    private List<Job> createSampleJobDTO() {
    List<Job> jobs = new ArrayList<>();
	 Job job1 = new Job();
       job1.setId(1L);
       job1.setDescription("");
       job1.setMinLevel(2);
       job1.setMaxLevel(10);
  
       
       jobs.add(job1);
       
       Job job2 = new Job();
       job2.setId(1L);
       job2.setDescription("");
       job2.setMinLevel(2);
       job2.setMaxLevel(10);
  
       jobs.add(job2);
       
       Job job3 = new Job();
       job3.setId(1L);
       job3.setDescription("");
       job3.setMinLevel(2);
       job3.setMaxLevel(10);
  
       
       jobs.add(job3);
       
       Job job4 = new Job();
       job4.setId(1L);
       job4.setDescription("");
       job4.setMinLevel(2);
       job4.setMaxLevel(10);
       
       jobs.add(job4);
       
       Job job5 = new Job();
       job5.setId(1L);
       job5.setDescription("");
       job5.setMinLevel(2);
       job5.setMaxLevel(10);
       
       jobs.add(job5);
       
       Job job6 = new Job();
       job6.setId(1L);
       job6.setDescription("");
       job6.setMinLevel(2);
       job6.setMaxLevel(10);
       
       jobs.add(job6);
	return jobs;
      
    }
       
       
       @Test
       void testGetAllJobs() {
           List<Job> jobs = createSampleJobDTO();
           when(jobRepository.findAll()).thenReturn(jobs);

           List<JobDTO> result = jobServiceImpl.getAllJobs();

           assertNotNull(result);
           assertEquals(jobs.size(), result.size());

           assertEquals(result.get(0).getId(), jobs.get(0).getId());
       }
       @Test
       void testGetJobById() {
           Long jobIdToSearch = 1L;
           Job job = createSampleJobDTO().get(0);
           when(jobRepository.findById(jobIdToSearch)).thenReturn(Optional.of(job));

           JobDTO result = jobServiceImpl.getJobById(jobIdToSearch);

           assertNotNull(result);
           assertEquals(job.getId(), result.getId());
   }
       
       @Test
       void testGetJobsByMinLevel() {
           Integer minLevelToSearch = 3;
           List<Job> expectedJobs = Arrays.asList(
                   new Job(),
                   new Job()
           );
           when(jobRepository.findByMinLevel(minLevelToSearch)).thenReturn(expectedJobs);
           
           List<JobDTO> result = jobServiceImpl.getJobsByMinLevel(minLevelToSearch);
            assertEquals(expectedJobs.size(), result.size());
           
       }
       @Test
       void testGetJobsByMaxLevel() {
           Integer maxLevelToSearch = 5;
           List<Job> expectedJobs = Arrays.asList(
                   new Job(),
                   new Job()
           );
           when(jobRepository.findByMaxLevel(maxLevelToSearch)).thenReturn(expectedJobs);
           List<JobDTO> result = jobServiceImpl.getJobsByMaxLevel(maxLevelToSearch);
           assertEquals(expectedJobs.size(), result.size());
          
       }
   }
      

   
    
    

	


