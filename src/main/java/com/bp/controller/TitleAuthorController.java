package com.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.TitleAuthorDTO;
import com.bp.service.TitleAuthorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/authortitles")
@CrossOrigin
public class TitleAuthorController {

    @Autowired
    private TitleAuthorService titleAuthorService;

    @PostMapping("/post")
    public ResponseEntity<String> addNewTitleAuthor(@Valid @RequestBody TitleAuthorDTO titleAuthorDTO) {
            String response = titleAuthorService.addNewTitleAuthor(titleAuthorDTO);
            return new ResponseEntity<String>(response, HttpStatus.CREATED);
        
    }
}
