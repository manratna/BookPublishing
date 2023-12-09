package com.bp.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.TitleRepository;
import com.bp.dao.entity.Publisher;
import com.bp.dao.entity.Title;
import com.bp.model.TitleDTO;

@SpringBootTest
class TitleServiceImplTest {

    @Mock
    private TitleRepository titleRepository;

    @InjectMocks
    private TitleServiceImpl titleServiceImpl;

    private List<Title> createSampleTitleDTO() {
    	List<Title> titles = new ArrayList<>();
        Title title = new Title();
        title.setId(1L);
        title.setTitle("Sample Title");
        title.setType("Fiction");
        title.setPrice(20);
        title.setAdvance(5);
        title.setRoyalty(10);
        title.setYtdSales(100);
        title.setNotes("Sample Notes");
        title.setPubdate("01-01-2023");

        Publisher publisher = new Publisher();
        publisher.setId(1L);
        publisher.setName("Sample Publisher");
        title.setPublisher(publisher);

        titles.add(title);
        
        return titles;
    }


    @Test
    void testGetAllTitles() {
        List<Title> titles = new ArrayList<>();
        titles.addAll(createSampleTitleDTO());
        when(titleRepository.findAll()).thenReturn(createSampleTitleDTO());

        List<TitleDTO> result = titleServiceImpl.getAllTitles();

        assertEquals(result.get(0).getPrice(), titles.get(0).getPrice());
        assertFalse(result.isEmpty());
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    
}
