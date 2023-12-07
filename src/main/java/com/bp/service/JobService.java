package com.bp.service;

import java.util.List;

import com.bp.model.JobDTO;

public interface JobService {
    String addJob(JobDTO jobDTO);

    List<JobDTO> getAllJobs();

    JobDTO getJobById(Long id);

    List<JobDTO> getJobsByMinLevel(Integer minLevel);

    List<JobDTO> getJobsByMaxLevel(Integer maxLevel);
}
