package com.bp.service;

import java.util.List;

import com.bp.model.TitleDTO;

public interface TitleService {

    String addNewTitle(TitleDTO titleDTO);

    List<TitleDTO> getAllTitles();

    TitleDTO searchTitleByTitle(String title);

    List<TitleDTO> searchTitlesByType(String type);

    List<TitleDTO> searchTitlesByPubId(Long pubId);

    List<TitleDTO> searchTitlesByPubDate(String pubDate);

    List<TitleDTO> searchTop5TitlesByYtd();
    
    List<TitleDTO> searchTop5ExpensiveTitles();

    TitleDTO updateAllTitleDetails(Long id, TitleDTO titleDTO);

    TitleDTO updateSpecificTitleDetails(Long id, TitleDTO titleDTO);
    
    List<TitleDTO> getTitlesByAuthorName(String Name);
    
    List<TitleDTO> searchTitlesByTitleContaining(String title);

    List<TitleDTO> searchTitlesByPubDateLike(String pubDate);
}
