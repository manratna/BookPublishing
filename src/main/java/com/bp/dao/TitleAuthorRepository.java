package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Author;
import com.bp.dao.entity.TitleAuthor;

public interface TitleAuthorRepository extends JpaRepository<TitleAuthor, Long> {

	 List<TitleAuthor> findByAuthor(Author author);
}
