package com.bp.service;
 
import java.util.List;
 
import com.bp.model.PublisherInfoDTO;
 
public interface PublisherInfoService {

 
    PublisherInfoDTO updatePublisherInfo(PublisherInfoDTO publisherInfoDTO);
 
    PublisherInfoDTO partialUpdatePublisherInfo(Long id, PublisherInfoDTO publisherInfoDTO);
 
	List<PublisherInfoDTO> getAllPublishersInfo();
}