package com.bp.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.PublisherInfoRepository;

@SpringBootTest
public class PublisherInfoServiceImplTest {

	@Mock
	PublisherInfoRepository publisherInfoRepository;
	
	@InjectMocks
	PublisherInfoServiceImpl publisherInfoServiceImpl;
	
	
}
