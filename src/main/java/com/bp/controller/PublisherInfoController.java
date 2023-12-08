// PublisherInfoController.java

package com.bp.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public PublisherInfoDTO updatePublisherInfo(@RequestBody PublisherInfoDTO publisherInfoDTO) {
        return publisherInfoService.updatePublisherInfo(publisherInfoDTO);
    }

    @PatchMapping("/{id}")
    public PublisherInfoDTO partialUpdatePublisherInfo(@PathVariable Long id, @RequestBody PublisherInfoDTO publisherInfoDTO) {
        return publisherInfoService.partialUpdatePublisherInfo(id, publisherInfoDTO);
    }
}
