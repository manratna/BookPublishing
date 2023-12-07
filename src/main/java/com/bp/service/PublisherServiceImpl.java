package com.bp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.PublisherRepository;
import com.bp.dao.entity.Publisher;
import com.bp.model.PublisherDTO;

@Service
public class PublisherServiceImpl implements PublisherService {

 @Autowired
 private PublisherRepository publisherRepository;

 @Override
 public String addPublisher(PublisherDTO publisherDTO) {
     Publisher publisher = new Publisher();
     BeanUtils.copyProperties(publisherDTO, publisher);
     publisherRepository.save(publisher);
     return "Record Created Successfully";
 }

 @Override
 public List<PublisherDTO> getAllPublishers() {
     return publisherRepository.findAll().stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<PublisherDTO> getPublisherByName(String name) {
     return publisherRepository.findByName(name).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<PublisherDTO> getPublisherByCity(String city) {
     return publisherRepository.findByCity(city).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<PublisherDTO> getPublisherByState(String state) {
     return publisherRepository.findByState(state).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public List<PublisherDTO> getPublisherByCountry(String country) {
     return publisherRepository.findByCountry(country).stream()
             .map(this::convertToDTO)
             .collect(Collectors.toList());
 }

 @Override
 public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO) {
     Publisher existingPublisher = publisherRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));

     BeanUtils.copyProperties(publisherDTO, existingPublisher);
     publisherRepository.save(existingPublisher);

     return convertToDTO(existingPublisher);
 }

 @Override
 public PublisherDTO partialUpdatePublisher(Long id, PublisherDTO publisherDTO) {
     Publisher existingPublisher = publisherRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));

     publisherRepository.save(existingPublisher);

     return convertToDTO(existingPublisher);
 }

 private PublisherDTO convertToDTO(Publisher publisher) {
     PublisherDTO publisherDTO = new PublisherDTO();
     BeanUtils.copyProperties(publisher, publisherDTO);
     return publisherDTO;
 }
}
