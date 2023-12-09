package com.bp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.PublisherInfoRepository;
import com.bp.dao.entity.Publisher;
import com.bp.dao.entity.PublisherInfo;
import com.bp.exception.NoDataAvailableException;
import com.bp.model.PublisherDTO;
import com.bp.model.PublisherInfoDTO;

@Service
public class PublisherInfoServiceImpl implements PublisherInfoService {

    @Autowired
    private PublisherInfoRepository publisherInfoRepository;

    @Override
    public PublisherInfoDTO updatePublisherInfo( PublisherInfoDTO publisherInfoDTO) {
    	try {
    		PublisherInfo publisherInfo = new PublisherInfo();
        	publisherInfo = copyProperties(publisherInfoDTO, publisherInfo);
            publisherInfoRepository.save(publisherInfo);
            return convertToDTO(publisherInfoRepository.getById(publisherInfoDTO.getId()));
    	}catch (Exception e) {
        	throw new NoDataAvailableException("NO data Available");
        }
    }

    @Override
    public PublisherInfoDTO partialUpdatePublisherInfo(Long id, PublisherInfoDTO publisherInfoDTO) {
        Optional<PublisherInfo> publisherInfoOptional = publisherInfoRepository.findById(id);
        if (publisherInfoOptional.isPresent()) {
            PublisherInfo publisherInfo = publisherInfoOptional.get();
            try {
            	publisherInfo = copyProperties(publisherInfoDTO, publisherInfo);
                publisherInfoRepository.save(publisherInfo);
                return convertToDTO(publisherInfo);
            } catch (Exception e) {
            	throw new NoDataAvailableException("NO data Available");
            }
        }
        return null;
    }

    private PublisherInfoDTO convertToDTO(PublisherInfo publisherInfo) {
        PublisherInfoDTO publisherInfoDTO = new PublisherInfoDTO();
        publisherInfoDTO = copyProperties(publisherInfo, publisherInfoDTO);
        return publisherInfoDTO;
    }

    private PublisherInfo copyProperties(PublisherInfoDTO source, PublisherInfo target) {
        BeanUtils.copyProperties(source, target);
        Publisher publisher = new Publisher();
        BeanUtils.copyProperties(source.getPublisher(), publisher);
        target.setPublisher(publisher);
        return target;
    }

    private PublisherInfoDTO copyProperties(PublisherInfo source, PublisherInfoDTO target) {
        BeanUtils.copyProperties(source, target);
        PublisherDTO publisherDTO = new PublisherDTO();
        BeanUtils.copyProperties(source.getPublisher(), publisherDTO);
        target.setPublisher(publisherDTO);
        return target;
    }
}
