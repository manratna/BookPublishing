package com.bp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.TitleAuthor;

public interface TitleAuthorRepository extends JpaRepository<TitleAuthor, Long> {
    // Additional custom queries can be added here if needed
}
