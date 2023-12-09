// AuthorServiceImpl.java

package com.bp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.AuthorRepository;
import com.bp.dao.TitleAuthorRepository;
import com.bp.dao.entity.Author;
import com.bp.dao.entity.Title;
import com.bp.dao.entity.TitleAuthor;
import com.bp.exception.InValidDataException;
import com.bp.model.AuthorDTO;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TitleAuthorRepository titleAuthorRepository;

    @Override
    public String addAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        BeanUtils.copyProperties(authorDTO, author);
        authorRepository.save(author);
        return "Record Created Successfully";
    }

    @Override
    public List<AuthorDTO> getAllAuthors()throws InValidDataException  {
        List<AuthorDTO> collect = authorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        if (collect.isEmpty()) {
			throw new InValidDataException("NO data Available");
		}
		return collect;
    }

    @Override
    public List<AuthorDTO> getAuthorsByLastName(String lastName) {
        List<AuthorDTO> collect = authorRepository.findByLastName(lastName).stream().map(this::convertToDTO).collect(Collectors.toList());
        if (collect.isEmpty()) {
			throw new InValidDataException("NO Author Availabe with LastName "+lastName);
		}
		return collect;
    }

    @Override
    public List<AuthorDTO> getAuthorsByFirstName(String firstName) {
        List<AuthorDTO> collect = authorRepository.findByFirstName(firstName).stream().map(this::convertToDTO).collect(Collectors.toList());
        if (collect.isEmpty()) {
			throw new InValidDataException("NO Author Availabe with FirstName "+firstName);
		}
		return collect;
		
    }

    @Override
    public AuthorDTO getAuthorByPhone(String phone) {
        return convertToDTO(authorRepository.findByPhone(phone));
    }

    @Override
    public List<AuthorDTO> getAuthorsByZip(String zip) {
        List<AuthorDTO> collect = authorRepository.findByZip(zip).stream().map(this::convertToDTO).collect(Collectors.toList());
        if (collect.isEmpty()) {
			throw new InValidDataException("NO Author Data is Available ");
		}
		return collect;
    }

    @Override
    public List<AuthorDTO> getAuthorsByState(String state) {
        List<AuthorDTO> collect = authorRepository.findByState(state).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
			throw new InValidDataException("Invalid Data Entered");
		}
		return collect;
    }

    @Override
    public List<AuthorDTO> getAuthorsByCity(String city) {
        List<AuthorDTO> collect = authorRepository.findByCity(city).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
			throw new InValidDataException("Author City is Invalid");
		}
		return collect;
    }

    @Override
    public void partialUpdateAuthor(Long id, AuthorDTO authorDTO) {
    	Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        BeanUtils.copyProperties(authorDTO, existingAuthor);
        authorRepository.save(existingAuthor);
    }

    @Override
    public void updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        BeanUtils.copyProperties(authorDTO, existingAuthor);
        authorRepository.save(existingAuthor);
    }

    @Override
    public List<Title> getTitlesByAuthorName(String name) {
        List<Author> authors = authorRepository.findByFirstNameOrLastName(name, name);
        List<TitleAuthor> titleAuthors = new ArrayList<>();
        for (Author author : authors) {
        	titleAuthors.addAll(titleAuthorRepository.findByAuthor(author));
		}
        List<Title> titles = new ArrayList<>();
        for (TitleAuthor titleAuthor : titleAuthors) {
			titles.add(titleAuthor.getTitle());
		}
        return titles;
    }

    private AuthorDTO convertToDTO(Author author) {
        AuthorDTO authorDTO = new AuthorDTO();
        BeanUtils.copyProperties(author, authorDTO);
        return authorDTO;
    }
}
