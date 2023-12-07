package com.bp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.RoyaltySchedule;

public interface RoyaltyScheduleRepository extends JpaRepository<RoyaltySchedule, Long> {
    // Additional custom queries can be added here if needed
}
