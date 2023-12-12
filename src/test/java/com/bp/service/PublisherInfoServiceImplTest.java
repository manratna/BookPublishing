package com.bp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;

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
    void testPartialUpdatePublisherInfoNotFoundException() {
        long publisherInfoId = 2L;
        PublisherInfoDTO updatedPublisherInfoDTO = new PublisherInfoDTO();

        when(publisherInfoRepository.findById(publisherInfoId)).thenReturn(Optional.empty());
        
        when(publisherInfoRepository.findById(publisherInfoId))
        .thenThrow(new PublisherNotFoundException("NO data Available"));

        assertThrows(PublisherNotFoundException.class,
                () -> publisherInfoServiceImpl.partialUpdatePublisherInfo(publisherInfoId, updatedPublisherInfoDTO));
    }
    
    
    
	
}
