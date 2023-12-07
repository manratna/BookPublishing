package com.bp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Discount;

public interface DiscountRepository extends JpaRepository<Discount, String> {
    // Additional custom queries can be added here if needed
}
