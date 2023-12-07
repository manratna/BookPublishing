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
import com.bp.model.PublisherDTO;
import com.bp.model.TitleDTO;

@Service
public class TitleServiceImpl implements TitleService {

	@Autowired
    private TitleRepository titleRepository;

    @Override
    public String addNewTitle(TitleDTO titleDTO) {
        Title title = new Title();
        try {
            BeanUtils.copyProperties(titleDTO, title);
            Publisher publisher = new Publisher();
            BeanUtils.copyProperties(titleDTO.getPublisher(), publisher);
            title.setPublisher(publisher);
            titleRepository.save(title);
            return "Record Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error Creating Record";
        }
    }

    @Override
    public List<TitleDTO> getAllTitles() {
        List<TitleDTO> titleDTOs = titleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return titleDTOs;
    }

    @Override
    public TitleDTO searchTitleByTitle(String title) {
        Title foundTitle = titleRepository.findByTitle(title);
        return (foundTitle != null) ? convertToDTO(foundTitle) : null;
    }

    @Override
    public List<TitleDTO> searchTitlesByType(String type) {
        List<Title> titles = titleRepository.findByType(type);
        return titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TitleDTO> searchTitlesByPubId(Long pubId) {
        List<Title> titles = titleRepository.findByPublisherId(pubId);
        return titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TitleDTO> searchTitlesByPubDate(String pubDate) {
        List<Title> titles = titleRepository.findByPubdate(pubDate);
        return titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TitleDTO> searchTop5TitlesByYtd() {
        List<Title> titles = titleRepository.findTop5ByOrderByYtdSalesDesc();
        return titles.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TitleDTO updateAllTitleDetails(Long id, TitleDTO titleDTO) {
        Optional<Title> titleOptional = titleRepository.findById(id);
        if (titleOptional.isPresent()) {
            Title title = titleOptional.get();
            try {
                BeanUtils.copyProperties(titleDTO, title);
                Publisher publisher = new Publisher();
                BeanUtils.copyProperties(titleDTO.getPublisher(), publisher);
                title.setPublisher(publisher);
                titleRepository.save(title);
                return convertToDTO(title);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
        return null;
    }

    @Override
    public TitleDTO updateSpecificTitleDetails(Long id, TitleDTO titleDTO) {
        Optional<Title> titleOptional = titleRepository.findById(id);
        if (titleOptional.isPresent()) {
            Title title = titleOptional.get();
            try {
                BeanUtils.copyProperties(titleDTO, title);
                Publisher publisher = new Publisher();
                BeanUtils.copyProperties(titleDTO.getPublisher(), publisher);
                title.setPublisher(publisher);
                titleRepository.save(title);
                return convertToDTO(title);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        }
        return null;
    }

    private TitleDTO convertToDTO(Title title) {
        TitleDTO titleDTO = new TitleDTO();
        try {
            BeanUtils.copyProperties(title, titleDTO);
            PublisherDTO publisherDTO = new PublisherDTO();
            BeanUtils.copyProperties(title.getPublisher(), publisherDTO);
            titleDTO.setPublisher(publisherDTO);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return titleDTO;
    }
}
