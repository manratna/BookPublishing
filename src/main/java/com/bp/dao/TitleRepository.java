package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {

    Title findByTitle(String title);

    List<Title> findByType(String type);

    List<Title> findByPublisherId(Long pubId);

    List<Title> findByPubdate(String pubDate);

    List<Title> findTop5ByOrderByYtdSalesDesc();
}
