// Updated PublisherRepository.java

package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findByName(String name);

    List<Publisher> findByCity(String city);

    List<Publisher> findByState(String state);

    List<Publisher> findByCountry(String country);

    // Additional custom queries can be added here if needed
}
