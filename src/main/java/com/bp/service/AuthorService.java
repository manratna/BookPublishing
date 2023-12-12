package com.bp.service;

import java.util.List;

import com.bp.dao.entity.Title;
import com.bp.model.AuthorDTO;

public interface AuthorService {
    String addAuthor(AuthorDTO authorDTO);

    List<AuthorDTO> getAllAuthors();

    List<AuthorDTO> getAuthorsByLastName(String lastName);

    List<AuthorDTO> getAuthorsByFirstName(String firstName);

    AuthorDTO getAuthorsByPhone(String phone);

    List<AuthorDTO> getAuthorsByZip(String zip);

    List<AuthorDTO> getAuthorsByState(String state);

    List<AuthorDTO> getAuthorsByCity(String city);

    AuthorDTO partialUpdateAuthor(Long id, AuthorDTO authorDTO);

    void updateAuthor(Long id, AuthorDTO authorDTO);
    
    public List<Title> getTitlesByAuthorName(String name);
}
