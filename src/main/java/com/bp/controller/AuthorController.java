package com.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.AuthorDTO;
import com.bp.service.AuthorService;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity<String> addAuthor(@RequestBody AuthorDTO authorDTO) {
        String response = authorService.addAuthor(authorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        List<AuthorDTO> authors = authorService.getAllAuthors();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/lname/{ln}")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByLastName(@PathVariable String ln) {
        List<AuthorDTO> authors = authorService.getAuthorsByLastName(ln);
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/fname/{fn}")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByFirstName(@PathVariable String fn) {
        List<AuthorDTO> authors = authorService.getAuthorsByFirstName(fn);
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/phone/{phno}")
    public ResponseEntity<AuthorDTO> getAuthorByPhone(@PathVariable String phno) {
        AuthorDTO author = authorService.getAuthorByPhone(phno);
        return ResponseEntity.ok(author);
    }

    @GetMapping("/zip/{zip}")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByZip(@PathVariable String zip) {
        List<AuthorDTO> authors = authorService.getAuthorsByZip(zip);
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByState(@PathVariable String state) {
        List<AuthorDTO> authors = authorService.getAuthorsByState(state);
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByCity(@PathVariable String city) {
        List<AuthorDTO> authors = authorService.getAuthorsByCity(city);
        return ResponseEntity.ok(authors);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> partialUpdateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        authorService.partialUpdateAuthor(id, authorDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.noContent().build();
    }
}
