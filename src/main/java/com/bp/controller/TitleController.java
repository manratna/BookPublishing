package com.bp.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.TitleDTO;
import com.bp.service.TitleService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/titles")
public class TitleController {
 
	@Autowired
    private TitleService titleService;
 
 
    @PostMapping("/post")
    public ResponseEntity<String> addNewTitle(@Valid @RequestBody TitleDTO titleDTO) {
        String addNewTitle = titleService.addNewTitle(titleDTO);
		return new ResponseEntity<String>(addNewTitle, HttpStatus.CREATED);
    }
 
    @GetMapping
    public ResponseEntity<List<TitleDTO>> getAllTitles() {
        List<TitleDTO> allTitles = titleService.getAllTitles();
		return new ResponseEntity<>(allTitles,HttpStatus.OK);
    }
 
    @GetMapping("/title/{title}")
    public ResponseEntity<TitleDTO> searchTitleByTitle(@PathVariable String title) {
        TitleDTO searchTitleByTitle = titleService.searchTitleByTitle(title);
		return new ResponseEntity<TitleDTO>(searchTitleByTitle, HttpStatus.OK);
    }
 
    @GetMapping("/type/{type}")
    public ResponseEntity<List<TitleDTO>> searchTitlesByType(@PathVariable String type) {
        List<TitleDTO> searchTitlesByType = titleService.searchTitlesByType(type);
		return new ResponseEntity<List<TitleDTO>>(searchTitlesByType,HttpStatus.OK);
    }
 
    @GetMapping("/pubid/{pubid}")
    public ResponseEntity<List<TitleDTO>> searchTitlesByPubId(@PathVariable Long pubid) {
        List<TitleDTO> searchTitlesByPubId = titleService.searchTitlesByPubId(pubid);
		return new ResponseEntity<List<TitleDTO>>(searchTitlesByPubId, HttpStatus.OK);
    }
 
    @GetMapping("/pubdate/{pubdate}")
    public ResponseEntity<List<TitleDTO>> searchTitlesByPubDate(@PathVariable String pubdate) {
        List<TitleDTO> searchTitlesByPubDate = titleService.searchTitlesByPubDate(pubdate);
		return new ResponseEntity<>( searchTitlesByPubDate,HttpStatus.OK);
    }
 
 
    @GetMapping("/top5titles")
    public ResponseEntity<List<TitleDTO>> searchTop5TitlesByYtd() {
        List<TitleDTO> searchTop5TitlesByYtd = titleService.searchTop5TitlesByYtd();
		return new ResponseEntity<List<TitleDTO>>(searchTop5TitlesByYtd, HttpStatus.OK);
    }
    
    @GetMapping("/top5ExpensiveTitles")
    public ResponseEntity<List<TitleDTO>> searchTop5ExpensiveTitles() {
        List<TitleDTO> searchTop5TitlesByYtd = titleService.searchTop5ExpensiveTitles();
		return new ResponseEntity<List<TitleDTO>>(searchTop5TitlesByYtd, HttpStatus.OK);
    }
 
    @PutMapping("/{id}")
    public ResponseEntity<TitleDTO> updateAllTitleDetails(@PathVariable Long id,@Valid @RequestBody TitleDTO titleDTO) {
        TitleDTO updateAllTitleDetails = titleService.updateAllTitleDetails(id, titleDTO);
		return new ResponseEntity<>(updateAllTitleDetails,HttpStatus.OK);
    }
 
    @PatchMapping("/{id}")
    public ResponseEntity<TitleDTO> updateSpecificTitleDetails(@PathVariable Long id, @RequestBody TitleDTO titleDTO) {
        TitleDTO updateSpecificTitleDetails = titleService.updateSpecificTitleDetails(id, titleDTO);
		return new ResponseEntity<>(updateSpecificTitleDetails,HttpStatus.OK);
    }
    
    @GetMapping("/authorName/{authorName}")
    public ResponseEntity<List<TitleDTO>> getTitlesByAuthorName(@PathVariable String authorName) {
        List<TitleDTO> titles = titleService.getTitlesByAuthorName(authorName);
        return new ResponseEntity<>(titles, HttpStatus.OK);
    }
    
    @GetMapping("/searchByTitleContaining/{title}")
    public ResponseEntity<List<TitleDTO>> searchTitlesByTitleContaining(@PathVariable String title) {
        List<TitleDTO> searchTitlesByTitleContaining = titleService.searchTitlesByTitleContaining(title);
        return new ResponseEntity<>(searchTitlesByTitleContaining, HttpStatus.OK);
    }

    @GetMapping("/searchByPubDateLike/{pubDate}")
    public ResponseEntity<List<TitleDTO>> searchTitlesByPubDateLike(@PathVariable String pubDate) {
        List<TitleDTO> searchTitlesByPubDateLike = titleService.searchTitlesByPubDateLike(pubDate);
        return new ResponseEntity<>(searchTitlesByPubDateLike, HttpStatus.OK);
    }
}