package com.bp.service;

import java.util.List;

import com.bp.model.PublisherDTO;

public interface PublisherService {
    String addPublisher(PublisherDTO publisherDTO);

    List<PublisherDTO> getAllPublishers();

    PublisherDTO getPublisherById(Long id);
    
    List<PublisherDTO> getPublisherByName(String name);

    List<PublisherDTO> getPublisherByCity(String city);

    List<PublisherDTO> getPublisherByState(String state);

    List<PublisherDTO> getPublisherByCountry(String country);

    PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO);

    PublisherDTO partialUpdatePublisher(Long id, PublisherDTO publisherDTO);
}
