package com.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.PublisherDTO;
import com.bp.service.PublisherService;

@RestController

@RequestMapping("/api/publishers")

public class PublisherController {

	@Autowired

	private PublisherService publisherService;

	@PostMapping("/post")

	public ResponseEntity<String> addNewPublisher(@RequestBody PublisherDTO publisherDTO) {

		String result = publisherService.addPublisher(publisherDTO);

		return new ResponseEntity<String>(result, HttpStatus.CREATED);

	}

	@GetMapping

	public ResponseEntity<List<PublisherDTO>> getAllPublishers() {

		List<PublisherDTO> publishers = publisherService.getAllPublishers();

		return new ResponseEntity<List<PublisherDTO>>(publishers, HttpStatus.OK);

	}

//	@GetMapping("/{id}")

//	public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Long id) {

//		PublisherDTO publisher = publisherService.searchPublishersById(id);

//		return new ResponseEntity<PublisherDTO>(publisher, HttpStatus.OK);

//	}

	@GetMapping("/pubname/{name}")

	public ResponseEntity<List<PublisherDTO>> searchPublishersByName(@PathVariable String name) {

		List<PublisherDTO> publisher = publisherService.getPublisherByName(name);

		return new ResponseEntity<List<PublisherDTO>>(publisher, HttpStatus.FOUND);

	}

	@GetMapping("/city/{city}")

	public ResponseEntity<List<PublisherDTO>> searchPublishersByCity(@PathVariable String city) {

		List<PublisherDTO> publisher = publisherService.getPublisherByCity(city);

		return new ResponseEntity<List<PublisherDTO>>(publisher, HttpStatus.FOUND);

	}

	@GetMapping("/state/{state}")

	public ResponseEntity<List<PublisherDTO>> searchPublishersByState(@PathVariable String state) {

		List<PublisherDTO> publisher = publisherService.getPublisherByState(state);

		return new ResponseEntity<List<PublisherDTO>>(publisher, HttpStatus.FOUND);

	}

	@GetMapping("/Country/{country}")

	public ResponseEntity<List<PublisherDTO>> searchPublishersByCountry(@PathVariable String country) {

		List<PublisherDTO> publisher = publisherService.getPublisherByCountry(country);

		return new ResponseEntity<List<PublisherDTO>>(publisher, HttpStatus.FOUND);

	}

	@PutMapping("/id")

	public ResponseEntity<Void> updatePublisherDetails(@PathVariable Long id, @RequestBody PublisherDTO publisherDTO) {

		publisherService.partialUpdatePublisher(id, publisherDTO);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@PatchMapping("/id")

	public ResponseEntity<Void> updateWholePublisherInfo(@PathVariable Long id,
			@RequestBody PublisherDTO publisherDTO) {

		publisherService.updatePublisher(id, publisherDTO);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}