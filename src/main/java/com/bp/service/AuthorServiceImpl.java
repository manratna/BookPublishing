// AuthorServiceImpl.java

package com.bp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.AuthorRepository;
import com.bp.dao.entity.Author;
import com.bp.model.AuthorDTO;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO, author);
        authorRepository.save(author);
        return "Record Created Successfully";
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> getAuthorsByLastName(String lastName) {
        return authorRepository.findByLastName(lastName).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> getAuthorsByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorByPhone(String phone) {
        return convertToDTO(authorRepository.findByPhone(phone));
    }

    @Override
    public List<AuthorDTO> getAuthorsByZip(String zip) {
        return authorRepository.findByZip(zip).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> getAuthorsByState(String state) {
        return authorRepository.findByState(state).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorDTO> getAuthorsByCity(String city) {
        return authorRepository.findByCity(city).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void partialUpdateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        // Implement partial update logic here, e.g., update only non-null properties
        if (authorDTO.getLastName() != null) {
            existingAuthor.setLastName(authorDTO.getLastName());
        }
        // Add similar logic for other properties

        authorRepository.save(existingAuthor);
    }

    @Override
    public void updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        BeanUtils.copyProperties(authorDTO, existingAuthor);
        authorRepository.save(existingAuthor);
    }

    private AuthorDTO convertToDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        BeanUtils.copyProperties(author, authorDTO);
        return authorDTO;
    }
}
