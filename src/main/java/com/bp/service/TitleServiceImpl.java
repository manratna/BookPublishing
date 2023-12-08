package com.bp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.TitleRepository;
import com.bp.dao.entity.Publisher;
import com.bp.dao.entity.Title;
import com.bp.exception.NoDataAvailableException;
import com.bp.model.PublisherDTO;
import com.bp.model.TitleDTO;

@Service
public class TitleServiceImpl implements TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public String addNewTitle(TitleDTO titleDTO) {
        Title title = new Title();
        BeanUtils.copyProperties(titleDTO, title);
        Publisher publisher = new Publisher();
        BeanUtils.copyProperties(titleDTO.getPublisher(), publisher);
        title.setPublisher(publisher);

        try {
            titleRepository.save(title);
            return "Record Created Successfully";
        } catch (Exception e) {
            throw new NoDataAvailableException("Error Creating Record");
        }
    }

    @Override
    public List<TitleDTO> getAllTitles() {
        List<TitleDTO> titleDTOs = titleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (titleDTOs.isEmpty()) {
            throw new NoDataAvailableException("No titles available");
        }
        return titleDTOs;
    }

    @Override
    public TitleDTO searchTitleByTitle(String title) {
        Title foundTitle = titleRepository.findByTitle(title);
        if (foundTitle != null) {
            return convertToDTO(foundTitle);
        } else {
            throw new NoDataAvailableException("Title not found");
        }
    }

    @Override
    public List<TitleDTO> searchTitlesByType(String type) {
        List<Title> titles = titleRepository.findByType(type);
        List<TitleDTO> titleDTOs = titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (titleDTOs.isEmpty()) {
            throw new NoDataAvailableException("No titles available for the given type");
        }
        return titleDTOs;
    }

    @Override
    public List<TitleDTO> searchTitlesByPubId(Long pubId) {
        List<Title> titles = titleRepository.findByPublisherId(pubId);
        List<TitleDTO> titleDTOs = titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (titleDTOs.isEmpty()) {
            throw new NoDataAvailableException("No titles available for the given publisher ID");
        }
        return titleDTOs;
    }

    @Override
    public List<TitleDTO> searchTitlesByPubDate(String pubDate) {
        List<Title> titles = titleRepository.findByPubdate(pubDate);
        List<TitleDTO> titleDTOs = titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (titleDTOs.isEmpty()) {
            throw new NoDataAvailableException("No titles available for the given publication date");
        }
        return titleDTOs;
    }

    @Override
    public List<TitleDTO> searchTop5TitlesByYtd() {
        List<Title> titles = titleRepository.findTop5ByOrderByYtdSalesDesc();
        List<TitleDTO> titleDTOs = titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if (titleDTOs.isEmpty()) {
            throw new NoDataAvailableException("No titles available for the top 5 sales");
        }
        return titleDTOs;
    }

    @Override
    public TitleDTO updateAllTitleDetails(Long id, TitleDTO titleDTO) {
        Optional<Title> titleOptional = titleRepository.findById(id);
        return titleOptional.map(title -> {
            BeanUtils.copyProperties(titleDTO, title);
            Publisher publisher = new Publisher();
            BeanUtils.copyProperties(titleDTO.getPublisher(), publisher);
            title.setPublisher(publisher);
            titleRepository.save(title);
            return convertToDTO(title);
        }).orElseThrow(() -> new NoDataAvailableException("Title not found"));
    }

    @Override
    public TitleDTO updateSpecificTitleDetails(Long id, TitleDTO titleDTO) {
        Optional<Title> titleOptional = titleRepository.findById(id);
        return titleOptional.map(title -> {
            BeanUtils.copyProperties(titleDTO, title);
            Publisher publisher = new Publisher();
            BeanUtils.copyProperties(titleDTO.getPublisher(), publisher);
            title.setPublisher(publisher);
            titleRepository.save(title);
            return convertToDTO(title);
        }).orElseThrow(() -> new NoDataAvailableException("Title not found"));
    }

    private TitleDTO convertToDTO(Title title) {
        TitleDTO titleDTO = new TitleDTO();
        BeanUtils.copyProperties(title, titleDTO);
        PublisherDTO publisherDTO = new PublisherDTO();
        BeanUtils.copyProperties(title.getPublisher(), publisherDTO);
        titleDTO.setPublisher(publisherDTO);
        return titleDTO;
    }
}