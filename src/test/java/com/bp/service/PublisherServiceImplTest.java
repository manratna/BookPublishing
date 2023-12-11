package com.bp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.PublisherRepository;
import com.bp.dao.entity.Publisher;
import com.bp.exception.PublisherNotFoundException;
import com.bp.model.PublisherDTO;

@SpringBootTest
public class PublisherServiceImplTest {
	
	@Mock
	PublisherRepository publisherRepository;
	
	@InjectMocks
	PublisherServiceImpl publisherServiceImpl;
	
	
	List<Publisher> samplePublisherDTO(){
		List<Publisher> publishers=new ArrayList<>();
		
		Publisher publisher1=new Publisher();
		publisher1.setId(1L);
		publisher1.setCity("Hyderabad");
		publisher1.setCountry("India");
		publisher1.setName("Ratnakar");
		publisher1.setState("TS");
		
		
		Publisher publisher2=new Publisher();
		publisher2.setId(2L);
		publisher2.setCity("Goa");
		publisher2.setCountry("India");
		publisher2.setName("Karthik");
		publisher2.setState("TS");
		
		
		Publisher publisher3=new Publisher();
		publisher3.setId(3L);
		publisher3.setCity("Vizak");
		publisher3.setCountry("India");
		publisher3.setName("Ravi");
		publisher3.setState("AP");
		
		
		Publisher publisher4=new Publisher();
		publisher4.setId(4L);
		publisher4.setCity("Kerala");
		publisher4.setCountry("India");
		publisher4.setName("Mohan");
		publisher4.setState("TS");
		
		
		Publisher publisher5=new Publisher();
		publisher5.setId(5L);
		publisher5.setCity("TamilNadu");
		publisher5.setCountry("India");
		publisher5.setName("Ashu");
		publisher5.setState("TS");
		
		publishers.add(publisher1);
		publishers.add(publisher2);
		publishers.add(publisher3);
		publishers.add(publisher4);
		publishers.add(publisher5);
		
		return publishers;
	}
	
	
	@Test
	public void testGetAllPublisher() {
		
		List<Publisher> publishers=new ArrayList<Publisher>();
		
		publishers.add(new Publisher((long) 1, "rathu", "hyd", "ts", "india"));
		when(publisherRepository.findAll()).thenReturn(publishers);
		
		
		List<PublisherDTO> expectedPublisher=new ArrayList<PublisherDTO>();
		expectedPublisher.add(new PublisherDTO((long) 1, "rathu", "hyd", "ts", "india"));

		
		List<PublisherDTO> actualPublisher=publisherServiceImpl.getAllPublishers();
		
		assertEquals(expectedPublisher.size(), actualPublisher.size());
		verify(publisherRepository).findAll();
		
	}
	
	@Test
	public void testGetPublisherById() {
		long publisherId=3L;
		when(publisherRepository.findById(publisherId)).thenReturn(Optional.of(samplePublisherDTO().get(2)));
				
		PublisherDTO publisherDTO=publisherServiceImpl.getPublisherById(publisherId);				
				
		assertEquals(publisherId, publisherDTO.getId());
		
	}
	
	@Test
	public void testGetPublisherByCity() {
		
		String findByCity="Goa";
		when(publisherRepository.findByCity(findByCity)).thenReturn(samplePublisherDTO());
		
		List<PublisherDTO> list=  publisherServiceImpl.getPublisherByCity(findByCity);
		
		boolean match = list.stream().anyMatch(dto->findByCity.equals(dto.getCity()));
		assertTrue( match);
		
	}
	
	@Test
	public void testGetPublisherByCountry() {
		
		String findByCountry="India";
		when(publisherRepository.findByCountry(findByCountry)).thenReturn(samplePublisherDTO());
		
		List<PublisherDTO> list=  publisherServiceImpl.getPublisherByCountry(findByCountry);
		
		boolean match = list.stream().anyMatch(dto->findByCountry.equals(dto.getCountry()));
		assertTrue( match);
		
	}
	
	@Test
	public void testGetPublisherByName() {
		
		String findByName="Mohan";
		when(publisherRepository.findByName(findByName)).thenReturn(samplePublisherDTO());
		
		List<PublisherDTO> list=  publisherServiceImpl.getPublisherByName(findByName);
		
		boolean match = list.stream().anyMatch(dto->findByName.equals(dto.getName()));
		assertTrue( match);
		
	}
	
	
	@Test
	public void testGetPublisherByState() {
		
		String findByState="TS";
		when(publisherRepository.findByState(findByState)).thenReturn(samplePublisherDTO());
		
		List<PublisherDTO> list=  publisherServiceImpl.getPublisherByState(findByState);
		
		boolean match = list.stream().anyMatch(dto->findByState.equals(dto.getState()));
		assertTrue( match);
		
	}
	
	
	
	@Test
	public void testGetAllPublisherException() {
		
        List<Publisher> publishers=new ArrayList<Publisher>();
		
		when(publisherRepository.findAll()).thenReturn(publishers);
		
		String expectedMessage="NO data Available";
		
		PublisherNotFoundException actualException=assertThrows(PublisherNotFoundException.class,()->publisherServiceImpl.getAllPublishers());
		
		String actualMessage=actualException.getMessage();
		
		assertEquals(expectedMessage,actualMessage);
		verify(publisherRepository).findAll();
	}
	
	@Test
	public void testGetPublisherByCityException() {
		
		List<Publisher> publishers=new ArrayList<Publisher>();
		when(publisherRepository.findAll()).thenReturn(publishers);
		
		String expectedMessage="No Publisher Available with city";
		PublisherNotFoundException actualException=assertThrows(PublisherNotFoundException.class,()->publisherServiceImpl.getPublisherByCity(expectedMessage));
		String actualMessage=actualException.getMessage();
		
		assertEquals(expectedMessage,actualMessage);
		verify(publisherRepository).findByCity(expectedMessage);
	}
	
	@Test
	public void testGetPublisherByCountryException() {
		
		List<Publisher> publishers=new ArrayList<Publisher>();
		when(publisherRepository.findAll()).thenReturn(publishers);
		
		String expectedMessage="No Publisher Available with country";
		PublisherNotFoundException actualException=assertThrows(PublisherNotFoundException.class,()->publisherServiceImpl.getPublisherByCountry(expectedMessage));
		String actualMessage=actualException.getMessage();
		
		assertEquals(expectedMessage,actualMessage);
		verify(publisherRepository).findByCountry(expectedMessage);
	}
	
	@Test
	public void testGetPublisherByNameException() {
		
		List<Publisher> publishers=new ArrayList<Publisher>();
		when(publisherRepository.findAll()).thenReturn(publishers);
		
		String expectedMessage="No Publisher Available with name";
		PublisherNotFoundException actualException=assertThrows(PublisherNotFoundException.class,()->publisherServiceImpl.getPublisherByName(expectedMessage));
		String actualMessage=actualException.getMessage();
		
		assertEquals(expectedMessage,actualMessage);
		verify(publisherRepository).findByName(expectedMessage);
	}
	
	@Test
	public void testGetPublisherByStateException() {
		
		List<Publisher> publishers=new ArrayList<Publisher>();
		when(publisherRepository.findAll()).thenReturn(publishers);
		
		String expectedMessage="No Publisher Available with state";
		PublisherNotFoundException actualException=assertThrows(PublisherNotFoundException.class,()->publisherServiceImpl.getPublisherByState(expectedMessage));
		String actualMessage=actualException.getMessage();
		
		assertEquals(expectedMessage,actualMessage);
		verify(publisherRepository).findByState(expectedMessage);
	}
	
	

}
