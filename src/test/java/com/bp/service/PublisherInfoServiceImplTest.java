package com.bp.service;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.PublisherInfoRepository;
import com.bp.dao.entity.Publisher;
import com.bp.dao.entity.PublisherInfo;
import com.bp.exception.PublisherNotFoundException;
import com.bp.model.PublisherInfoDTO;
 
@SpringBootTest
public class PublisherInfoServiceImplTest {
 
	@Mock
	PublisherInfoRepository publisherInfoRepository;
 
	@InjectMocks
	PublisherInfoServiceImpl publisherInfoServiceImpl;
 
	@Test
	void testUpdatePublisherInfoException() {
 
		long publisherId = 2L;
		PublisherInfoDTO publisherInfoDTO = new PublisherInfoDTO();
		publisherInfoDTO.setId(publisherId);
 
		when(publisherInfoRepository.findById(publisherId))
				.thenThrow(new PublisherNotFoundException("NO data Available"));
 
		assertThrows(PublisherNotFoundException.class,
				() -> publisherInfoServiceImpl.updatePublisherInfo(publisherInfoDTO));
	}

	@Test
	void testPartialUpdatePublisherInfoException() {
		long publisherInfoId = 2L;
		PublisherInfoDTO updatedPublisherInfoDTO = new PublisherInfoDTO();
 
		when(publisherInfoRepository.findById(publisherInfoId)).thenReturn(Optional.empty());
 
		when(publisherInfoRepository.findById(publisherInfoId))
				.thenThrow(new PublisherNotFoundException("NO data Available"));
 
		assertThrows(PublisherNotFoundException.class,
				() -> publisherInfoServiceImpl.partialUpdatePublisherInfo(publisherInfoId, updatedPublisherInfoDTO));
	}
 
 
	@Test
    void testGetAllPublishersInfo() {
        List<PublisherInfo> publisherInfoList = new ArrayList<PublisherInfo>();
        List<Publisher> publishers=new ArrayList<Publisher>();
        publisherInfoList.add(new PublisherInfo(1l,new Publisher(1l,"Ratnakar","Hyderabad", "Ts","India"),"Logo", "Information"));
 
        when(publisherInfoRepository.findAll()).thenReturn(publisherInfoList);
 
     
        List<PublisherInfoDTO> result = publisherInfoServiceImpl.getAllPublishersInfo();
 
        assertFalse(result.isEmpty());
        assertEquals(publisherInfoList.size(), result.size());
    }
 
    @Test
    void testGetAllPublishersInfoException() {
        when(publisherInfoRepository.findAll()).thenReturn(Collections.emptyList());
 
        PublisherNotFoundException exception = assertThrows(PublisherNotFoundException.class,
            () -> publisherInfoServiceImpl.getAllPublishersInfo());
        assertEquals("NO data Available", exception.getMessage());
    }
}