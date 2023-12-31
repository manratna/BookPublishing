package com.bp.service;
 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.PublisherRepository;
import com.bp.dao.entity.Publisher;
import com.bp.exception.PublisherNotFoundException;
import com.bp.model.PublisherDTO;
 
@Service
public class PublisherServiceImpl implements PublisherService {
 
	@Autowired
	private PublisherRepository publisherRepository;
 
	@Override
	public String addPublisher(PublisherDTO publisherDTO) {
		Publisher publisher = new Publisher();
		BeanUtils.copyProperties(publisherDTO, publisher);
		try {
		publisherRepository.save(publisher);
		return "Record Created Successfully";
		}catch (Exception e) {
			throw new PublisherNotFoundException("Error adding record");
		}
	}
 
	
	@Override
	public PublisherDTO getPublisherById(Long id) {
		
		 Optional<Publisher> findById = publisherRepository.findById(id);
		 
		return findById.map(this::convertToDTO).orElseThrow(()->new PublisherNotFoundException("No Publishers available with id "+id));
		
	}
	
	@Override
	public List<PublisherDTO> getAllPublishers() {
		List<PublisherDTO> collect = publisherRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
		if (collect.isEmpty()) {
			throw new PublisherNotFoundException("NO data Available");
		}
		return collect;
 
	}
 
	@Override
	public List<PublisherDTO> getPublisherByName(String name) {
		List<PublisherDTO> collect = publisherRepository.findByName(name).stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new PublisherNotFoundException("No Publisher Available with name");
		}
		return collect;
	}
 
	@Override
	public List<PublisherDTO> getPublisherByCity(String city) {
		List<PublisherDTO> collect = publisherRepository.findByCity(city).stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new PublisherNotFoundException("No Publisher Available with city");
		}
		return collect;
	}
 
	@Override
	public List<PublisherDTO> getPublisherByState(String state) {
		List<PublisherDTO> collect = publisherRepository.findByState(state).stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new PublisherNotFoundException("No Publisher Available with state");
		}
		return collect;
	}
 
	@Override
	public List<PublisherDTO> getPublisherByCountry(String country){
		List<PublisherDTO> collect = publisherRepository.findByCountry(country).stream().map(this::convertToDTO).collect(Collectors.toList());
		if(collect.isEmpty()) {
			throw new PublisherNotFoundException("No Publisher Available with country");
		}
		return collect;
	}
 
	@Override
	public PublisherDTO updatePublisher(Long id, PublisherDTO publisherDTO){
		Publisher existingPublisher = publisherRepository.findById(id)
				.orElseThrow(() -> new PublisherNotFoundException("Publisher not found with id: " + id));
 
		BeanUtils.copyProperties(publisherDTO, existingPublisher);
		publisherRepository.save(existingPublisher);
 
		return convertToDTO(existingPublisher);
	}
 
	@Override
	public PublisherDTO partialUpdatePublisher(Long id, PublisherDTO publisherDTO) {

		Optional<Publisher> optional = publisherRepository.findById(id);
		if (optional.isPresent()) {
			
			Publisher publisher=optional.get();
			
			if(publisherDTO.getId()!=null) {
				publisher.setId(publisherDTO.getId());
			}
			
			if (publisherDTO.getName()!=null) {
				publisher.setName(publisherDTO.getName());
			}
			
			if (publisherDTO.getCity()!=null) {
				publisher.setCity(publisherDTO.getCity());
			}

			if (publisherDTO.getState()!=null) {
				publisher.setState(publisherDTO.getState());
			}

			if (publisherDTO.getCountry()!=null) {
				publisher.setCountry(publisherDTO.getCountry());
			}
			publisherRepository.save(publisher);
			return convertToDTO(publisher);
		}else {
			throw new PublisherNotFoundException("Publisher not found with id");
		}

	}
 
	private PublisherDTO convertToDTO(Publisher publisher) {
		PublisherDTO publisherDTO = new PublisherDTO();
		BeanUtils.copyProperties(publisher, publisherDTO);
		return publisherDTO;
	}

	
}