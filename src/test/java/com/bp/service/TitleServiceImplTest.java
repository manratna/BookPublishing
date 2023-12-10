package com.bp.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.bp.exception.TitleNotFoundException;
import com.bp.model.TitleDTO;

@SpringBootTest
class TitleServiceImplTest {

    @Mock
    private TitleRepository titleRepository;

    @InjectMocks
    private TitleServiceImpl titleServiceImpl;

    private List<Title> createSampleTitleDTO() {
        List<Title> titles = new ArrayList<>();

        Title title1 = new Title();
        title1.setId(1L);
        title1.setTitle("The Quantum Code: Unraveling the Mystery");
        title1.setType("science");
        title1.setPrice(19);
        title1.setAdvance(5000);
        title1.setRoyalty(8);
        title1.setYtdSales(3000);
        title1.setNotes("Exploring the fascinating world of quantum physics. Clear explanations and thought-provoking theories.");
        title1.setPubdate("09-14-1993");

        Publisher publisher1 = new Publisher();
        publisher1.setId(63L);
        publisher1.setName("Boston");
        title1.setPublisher(publisher1);

        titles.add(title1);

        Title title2 = new Title();
        title2.setId(2L);
        title2.setTitle("Beyond the Stars: Galactic Exploration");
        title2.setType("science_fiction");
        title2.setPrice(29);
        title2.setAdvance(8000);
        title2.setRoyalty(12);
        title2.setYtdSales(6500);
        title2.setNotes("Epic tales of interstellar adventures. A thrilling journey beyond the stars.");
        title2.setPubdate("05-08-1994");

        Publisher publisher2 = new Publisher();
        publisher2.setId(64L);
        publisher2.setName("Washington");
        title2.setPublisher(publisher2);

        titles.add(title2);

        Title title3 = new Title();
        title3.setId(3L);
        title3.setTitle("Green Living: Sustainable Lifestyles");
        title3.setType("environment");
        title3.setPrice(24);
        title3.setAdvance(6000);
        title3.setRoyalty(10);
        title3.setYtdSales(4200);
        title3.setNotes("Practical tips for adopting a green and sustainable lifestyle. Eco-friendly practices for everyday living.");
        title3.setPubdate("10-20-1993");

        Publisher publisher3 = new Publisher();
        publisher3.setId(65L);
        publisher3.setName("Berkeley");
        title3.setPublisher(publisher3);

        titles.add(title3);

        Title title4 = new Title();
        title4.setId(4L);
        title4.setTitle("The Art of Mindful Parenting");
        title4.setType("psychology");
        title4.setPrice(16);
        title4.setAdvance(3000);
        title4.setRoyalty(6);
        title4.setYtdSales(1800);
        title4.setNotes("Applying mindfulness principles to parenting. Building strong connections and fostering a positive family environment.");
        title4.setPubdate("03-03-1994");

        Publisher publisher4 = new Publisher();
        publisher4.setId(66L);
        publisher4.setName("New York");
        title4.setPublisher(publisher4);

        titles.add(title4);

        Title title5 = new Title();
        title5.setId(5L);
        title5.setTitle("Blockchain Revolution: Decentralized Future");
        title5.setType("technology");
        title5.setPrice(32);
        title5.setAdvance(10000);
        title5.setRoyalty(15);
        title5.setYtdSales(7500);
        title5.setNotes("Revolutionizing industries with blockchain technology. Insights into the decentralized future.");
        title5.setPubdate("08-12-1993");

        Publisher publisher5 = new Publisher();
        publisher5.setId(67L);
        publisher5.setName("Chicago");
        title5.setPublisher(publisher5);

        titles.add(title5);

        Title title6 = new Title();
        title6.setId(6L);
        title6.setTitle("Epic Fantasy Chronicles: Legends Unveiled");
        title6.setType("fantasy");
        title6.setPrice(26);
        title6.setAdvance(7000);
        title6.setRoyalty(14);
        title6.setYtdSales(5800);
        title6.setNotes("Dive into the world of epic fantasy. Chronicles of legendary heroes and mythical creatures.");
        title6.setPubdate("12-07-1992");

        Publisher publisher6 = new Publisher();
        publisher6.setId(62L);
        publisher6.setName("Dallas");
        title6.setPublisher(publisher6);

        titles.add(title6);

        Title title7 = new Title();
        title7.setId(7L);
        title7.setTitle("Healthy Aging: Wellness for a Lifetime");
        title7.setType("health");
        title7.setPrice(18);
        title7.setAdvance(4000);
        title7.setRoyalty(8);
        title7.setYtdSales(3200);
        title7.setNotes("Guidance on maintaining health and vitality as you age. Practical advice for a fulfilling and active lifestyle.");
        title7.setPubdate("06-19-1994");

        Publisher publisher7 = new Publisher();
        publisher7.setId(61L);
        publisher7.setName("München");
        title7.setPublisher(publisher7);

        titles.add(title7);

        Title title8 = new Title();
        title8.setId(8L);
        title8.setTitle("Innovation Nation: Stories of Creative Genius");
        title8.setType("history");
        title8.setPrice(23);
        title8.setAdvance(5500);
        title8.setRoyalty(10);
        title8.setYtdSales(4600);
        title8.setNotes("Exploring historical stories of innovation and creative genius. The impact of inventions on society.");
        title8.setPubdate("02-15-1993");

        Publisher publisher8 = new Publisher();
        publisher8.setId(60L);
        publisher8.setName("Paris");
        title8.setPublisher(publisher8);

        titles.add(title8);

        Title title9 = new Title();
        title9.setId(9L);
        title9.setTitle("The Joy of Painting: Artistic Inspirations");
        title9.setType("art");
        title9.setPrice(21);
        title9.setAdvance(4500);
        title9.setRoyalty(9);
        title9.setYtdSales(3800);
        title9.setNotes("Discovering the joy of painting. Artistic inspirations and techniques for aspiring artists.");
        title9.setPubdate("07-28-1993");

        Publisher publisher9 = new Publisher();
        publisher9.setId(59L);
        publisher9.setName("Tokyo");
        title9.setPublisher(publisher9);

        titles.add(title9);

        Title title10 = new Title();
        title10.setId(10L);
        title10.setTitle("Discovering the Cosmos: Cosmic Wonders");
        title10.setType("science");
        title10.setPrice(28);
        title10.setAdvance(7500);
        title10.setRoyalty(12);
        title10.setYtdSales(6200);
        title10.setNotes("A cosmic journey through the wonders of the universe. Unveiling the mysteries of the cosmos.");
        title10.setPubdate("11-02-1993");

        Publisher publisher10 = new Publisher();
        publisher10.setId(58L);
        publisher10.setName("Seattle");
        title10.setPublisher(publisher10);

        titles.add(title10);

        return titles;

    }



    @Test
    void testGetAllTitles() {
        List<Title> titles = new ArrayList<>();
        titles.addAll(createSampleTitleDTO());
        when(titleRepository.findAll()).thenReturn(createSampleTitleDTO());

        List<TitleDTO> result = titleServiceImpl.getAllTitles();

        assertEquals(result.get(0).getPrice(), titles.get(0).getPrice());
        assertNotNull(result);
        assertEquals(10, result.size());
    }
    
    @Test
    void testSearchTitleByTitle() {
        // Arrange
        String titleToSearch = "The Quantum Code: Unraveling the Mystery";
        when(titleRepository.findByTitle(titleToSearch)).thenReturn(createSampleTitleDTO().get(0));

        // Act
        TitleDTO result = titleServiceImpl.searchTitleByTitle(titleToSearch);

        // Assert
        assertNotNull(result);
        assertEquals(titleToSearch, result.getTitle());
    }

    @Test
    void testSearchTitlesByType() {
        // Arrange
        String typeToSearch = "science";
        when(titleRepository.findByType(typeToSearch)).thenReturn(createSampleTitleDTO().subList(0, 2));

        // Act
        List<TitleDTO> result = titleServiceImpl.searchTitlesByType(typeToSearch);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(typeToSearch, result.get(0).getType());
    }

    @Test
    void testSearchTitlesByPubId() {
        // Arrange
        Long publisherId = 63L;
        when(titleRepository.findByPublisherId(publisherId)).thenReturn(createSampleTitleDTO().subList(0, 1));

        // Act
        List<TitleDTO> result = titleServiceImpl.searchTitlesByPubId(publisherId);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(publisherId, result.get(0).getPublisher().getId());
    }

    @Test
    void testSearchTitlesByPubDate() {
        // Arrange
        String pubDateToSearch = "09-14-1993";
        when(titleRepository.findByPubdate(pubDateToSearch)).thenReturn(createSampleTitleDTO().subList(0, 1));

        // Act
        List<TitleDTO> result = titleServiceImpl.searchTitlesByPubDate(pubDateToSearch);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(pubDateToSearch, result.get(0).getPubdate());
    }

    @Test
    void testSearchTop5TitlesByYtd() {
        // Arrange
        when(titleRepository.findTop5ByOrderByYtdSalesDesc()).thenReturn(createSampleTitleDTO().subList(0, 5));

        // Act
        List<TitleDTO> result = titleServiceImpl.searchTop5TitlesByYtd();

        // Assert
        assertNotNull(result);
        assertEquals(5, result.size());
        assertEquals("The Quantum Code: Unraveling the Mystery", result.get(0).getTitle());
    }
    
    @Test
    void testGetAllTitlesException() {
        // Arrange
        when(titleRepository.findAll()).thenReturn(new ArrayList<>());

        // Act and Assert
        TitleNotFoundException exception = assertThrows(TitleNotFoundException.class, () -> titleServiceImpl.getAllTitles());
        String expectedMessage = "No titles available";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSearchTitleByTitleException() {
        // Arrange
        String nonExistentTitle = "Non-Existent Title";
        when(titleRepository.findByTitle(nonExistentTitle)).thenReturn(null);

        // Act and Assert
        TitleNotFoundException exception = assertThrows(TitleNotFoundException.class, () -> titleServiceImpl.searchTitleByTitle(nonExistentTitle));
        String expectedMessage = "Title not found";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSearchTitlesByTypeException() {
        // Arrange
        String nonExistentType = "Non-Existent Type";
        when(titleRepository.findByType(nonExistentType)).thenReturn(new ArrayList<>());

        // Act and Assert
        TitleNotFoundException exception = assertThrows(TitleNotFoundException.class, () -> titleServiceImpl.searchTitlesByType(nonExistentType));
        String expectedMessage = "No titles available for the given type";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSearchTitlesByPubIdException() {
        // Arrange
        Long nonExistentPubId = 999L;
        when(titleRepository.findByPublisherId(nonExistentPubId)).thenReturn(new ArrayList<>());

        // Act and Assert
        TitleNotFoundException exception = assertThrows(TitleNotFoundException.class, () -> titleServiceImpl.searchTitlesByPubId(nonExistentPubId));
        String expectedMessage = "No titles available for the given publisher ID";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSearchTitlesByPubDateException() {
        // Arrange
        String nonExistentPubDate = "01-01-2099";
        when(titleRepository.findByPubdate(nonExistentPubDate)).thenReturn(new ArrayList<>());

        // Act and Assert
        TitleNotFoundException exception = assertThrows(TitleNotFoundException.class, () -> titleServiceImpl.searchTitlesByPubDate(nonExistentPubDate));
        String expectedMessage = "No titles available for the given publication date";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
