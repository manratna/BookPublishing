package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bp.dao.entity.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {

    Title findByTitle(String title);

    List<Title> findByType(String type);

    List<Title> findByPublisherId(Long pubId);

    List<Title> findByPubdate(String pubDate);

    List<Title> findTop5ByOrderByYtdSalesDesc();
    
    @Query("SELECT t FROM Title t " +
            "JOIN TitleAuthor ta ON t.id = ta.title.id " +
            "JOIN Author a ON ta.author.id = a.id " +
            "WHERE a.lastName = :name OR a.firstName = :name")
    List<Title> findByAuthorName(@Param("name") String name);
    
    List<Title> findTop5ByOrderByPriceDesc();
    
    List<Title> findByTitleContaining(String title);

    List<Title> findByPubdateLike(String pubDate);
    
}
