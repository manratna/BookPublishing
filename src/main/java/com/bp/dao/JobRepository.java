package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByMinLevel(Integer minLevel);

    List<Job> findByMaxLevel(Integer maxLevel);

}
