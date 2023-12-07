package com.bp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.dao.PublisherRepository;
import com.bp.dao.entity.Publisher;
import com.bp.model.PublisherDTO;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @PostMapping("/post")
    public ResponseEntity<String> addPublisher(@RequestBody PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        BeanUtils.copyProperties(publisherDTO, publisher);
        publisherRepository.save(publisher);
        return ResponseEntity.ok("Record Created Successfully");
    }

    @GetMapping
    public ResponseEntity<List<PublisherDTO>> getAllPublishers() {
        List<PublisherDTO> publishers = publisherRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/pubname/{name}")
    public ResponseEntity<List<PublisherDTO>> getPublisherByName(@PathVariable String name) {
        List<PublisherDTO> publishers = publisherRepository.findByName(name).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<PublisherDTO>> getPublisherByCity(@PathVariable String city) {
        List<PublisherDTO> publishers = publisherRepository.findByCity(city).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/state/{state}")
    public ResponseEntity<List<PublisherDTO>> getPublisherByState(@PathVariable String state) {
        List<PublisherDTO> publishers = publisherRepository.findByState(state).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/country/{country}")
    public ResponseEntity<List<PublisherDTO>> getPublisherByCountry(@PathVariable String country) {
        List<PublisherDTO> publishers = publisherRepository.findByCountry(country).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(publishers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        Publisher existingPublisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));

        BeanUtils.copyProperties(publisherDTO, existingPublisher);
        publisherRepository.save(existingPublisher);

        return ResponseEntity.ok(convertToDTO(existingPublisher));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PublisherDTO> partialUpdatePublisher(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {
        Publisher existingPublisher = publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));

        // Implement partial update logic here, e.g., update only non-null properties

        publisherRepository.save(existingPublisher);

        return ResponseEntity.ok(convertToDTO(existingPublisher));
    }

    private PublisherDTO convertToDTO(Publisher publisher) {
        PublisherDTO publisherDTO = new PublisherDTO();
        BeanUtils.copyProperties(publisher, publisherDTO);
        return publisherDTO;
    }
}
