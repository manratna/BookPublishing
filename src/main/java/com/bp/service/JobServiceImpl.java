package com.bp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.JobRepository;
import com.bp.dao.entity.Job;
import com.bp.model.JobDTO;

@Service
public class JobServiceImpl implements JobService {

 @Autowired
 private JobRepository jobRepository;

 @Override
 public String addJob(JobDTO jobDTO) {
     Job job = new Job();
     BeanUtils.copyProperties(jobDTO, job);
     jobRepository.save(job);
     return "Record Created Successfully";
 }

 @Override
 public List<JobDTO> getAllJobs() {
     return jobRepository.findAll().stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public JobDTO getJobById(Long id) {
     Job job = jobRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
     return convertToDTO(job);
 }

 @Override
 public List<JobDTO> getJobsByMinLevel(Integer minLevel) {
     return jobRepository.findByMinLevel(minLevel).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<JobDTO> getJobsByMaxLevel(Integer maxLevel) {
     return jobRepository.findByMaxLevel(maxLevel).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 private JobDTO convertToDTO(Job job) {
     JobDTO jobDTO = new JobDTO();
     BeanUtils.copyProperties(job, jobDTO);
     return jobDTO;
 }
}
