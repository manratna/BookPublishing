package com.bp.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.PublisherInfoDTO;
import com.bp.service.PublisherInfoService;

import jakarta.validation.Valid;
@CrossOrigin
@RestController
@RequestMapping("/api/pubinfo")
public class PublisherInfoController {
 
    @Autowired
    private PublisherInfoService publisherInfoService;
    @GetMapping
	public ResponseEntity<List<PublisherInfoDTO>> getAllPublishersInfo() {
		List<PublisherInfoDTO> publishers = publisherInfoService.getAllPublishersInfo();
		return new ResponseEntity<List<PublisherInfoDTO>>(publishers, HttpStatus.OK);
	}
 
 
    @PutMapping("/{id}")
    public ResponseEntity<PublisherInfoDTO> updatePublisherInfo(@PathVariable Long id,@Valid @RequestBody PublisherInfoDTO publisherInfoDTO) {
        PublisherInfoDTO updatePublisherInfo = publisherInfoService.updatePublisherInfo(publisherInfoDTO);
		return new ResponseEntity<PublisherInfoDTO>(updatePublisherInfo,HttpStatus.OK);
    }
 
    @PatchMapping("/{id}")
    public ResponseEntity<PublisherInfoDTO> partialUpdatePublisherInfo(@PathVariable Long id,@RequestBody PublisherInfoDTO publisherInfoDTO) {
        PublisherInfoDTO partialUpdatePublisherInfo = publisherInfoService.partialUpdatePublisherInfo(id, publisherInfoDTO);
		return new ResponseEntity<PublisherInfoDTO>(partialUpdatePublisherInfo,HttpStatus.OK);
    }
}