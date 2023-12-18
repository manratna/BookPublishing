package com.bp.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.JobDTO;
import com.bp.service.JobService;

import jakarta.validation.Valid;
 
@CrossOrigin
@RestController
@RequestMapping("/api/jobs")
public class JobController {
 
    @Autowired
    private JobService jobService;
 
    @PostMapping
    public ResponseEntity<String> addJob(@Valid @RequestBody JobDTO jobDTO) {
        String response = jobService.addJob(jobDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
 
    @GetMapping
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<JobDTO> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<JobDTO> getJobById(@PathVariable Long id) {
        JobDTO job = jobService.getJobById(id);
        return ResponseEntity.ok(job);
    }
 
    @GetMapping("/minlvl/{minlvl}")
    public ResponseEntity<List<JobDTO>> getJobsByMinLevel(@PathVariable Integer minlvl) {
        List<JobDTO> jobs = jobService.getJobsByMinLevel(minlvl);
        return ResponseEntity.ok(jobs);
    }
 
    @GetMapping("/maxlvl/{maxlvl}")
    public ResponseEntity<List<JobDTO>> getJobsByMaxLevel(@PathVariable Integer maxlvl) {
        List<JobDTO> jobs = jobService.getJobsByMaxLevel(maxlvl);
        return ResponseEntity.ok(jobs);
    }
}