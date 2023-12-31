package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Author;
import com.bp.dao.entity.TitleAuthor;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByLastName(String lastName);

    List<Author> findByFirstName(String firstName);

    Author findByPhone(String phone);

    List<Author> findByZip(String zip);

    List<Author> findByState(String state);

    List<Author> findByCity(String city);

	List<Author> findByFirstNameOrLastName(String firstName, String lastName);
}
