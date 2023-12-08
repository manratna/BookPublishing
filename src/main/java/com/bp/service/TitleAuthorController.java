package com.bp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.TitleAuthorDTO;
@RestController
@RequestMapping("/api/authortitles")
public class TitleAuthorController {

    @Autowired
    private TitleAuthorService titleAuthorService;

    @PostMapping("/post")
    public ResponseEntity<String> addNewTitleAuthor(@RequestBody TitleAuthorDTO titleAuthorDTO) {
        String response = titleAuthorService.addNewTitleAuthor(titleAuthorDTO);
        return ResponseEntity.ok(response);
    }




}
