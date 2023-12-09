// PublisherInfoController.java

package com.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.PublisherInfoDTO;
import com.bp.service.PublisherInfoService;

@RestController
@RequestMapping("/api/pubinfo")
public class PublisherInfoController {

    @Autowired
    private PublisherInfoService publisherInfoService;

    @PutMapping("/{id}")
    public ResponseEntity<PublisherInfoDTO> updatePublisherInfo(@RequestBody PublisherInfoDTO publisherInfoDTO) {
        PublisherInfoDTO updatePublisherInfo = publisherInfoService.updatePublisherInfo(publisherInfoDTO);
		return new ResponseEntity<>(updatePublisherInfo,HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PublisherInfoDTO> partialUpdatePublisherInfo(@PathVariable Long id, @RequestBody PublisherInfoDTO publisherInfoDTO) {
        PublisherInfoDTO partialUpdatePublisherInfo = publisherInfoService.partialUpdatePublisherInfo(id, publisherInfoDTO);
		return new ResponseEntity<>(partialUpdatePublisherInfo,HttpStatus.OK);
    }
}
