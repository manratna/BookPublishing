package com.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/api/titles")
public class TitleController {

	@Autowired
    private TitleService titleService;


    @PostMapping("/post")
    public String addNewTitle(@RequestBody TitleDTO titleDTO) {
        return titleService.addNewTitle(titleDTO);
    }

    @GetMapping
    public List<TitleDTO> getAllTitles() {
        return titleService.getAllTitles();
    }

    @GetMapping("/title/{title}")
    public TitleDTO searchTitleByTitle(@PathVariable String title) {
        return titleService.searchTitleByTitle(title);
    }

    @GetMapping("/type/{type}")
    public List<TitleDTO> searchTitlesByType(@PathVariable String type) {
        return titleService.searchTitlesByType(type);
    }

    @GetMapping("/pubid/{pubid}")
    public List<TitleDTO> searchTitlesByPubId(@PathVariable Long pubid) {
        return titleService.searchTitlesByPubId(pubid);
    }

    @GetMapping("/pubdate/{pubdate}")
    public List<TitleDTO> searchTitlesByPubDate(@PathVariable String pubdate) {
        return titleService.searchTitlesByPubDate(pubdate);
    }


    @GetMapping("/top5titles")
    public List<TitleDTO> searchTop5TitlesByYtd() {
        return titleService.searchTop5TitlesByYtd();
    }

    @PutMapping("/{id}")
    public TitleDTO updateAllTitleDetails(@PathVariable Long id, @RequestBody TitleDTO titleDTO) {
        return titleService.updateAllTitleDetails(id, titleDTO);
    }

    @PatchMapping("/{id}")
    public TitleDTO updateSpecificTitleDetails(@PathVariable Long id, @RequestBody TitleDTO titleDTO) {
        return titleService.updateSpecificTitleDetails(id, titleDTO);
    }
}
