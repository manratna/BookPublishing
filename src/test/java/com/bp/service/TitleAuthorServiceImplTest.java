package com.bp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.TitleAuthorRepository;
import com.bp.dao.entity.Author;
import com.bp.dao.entity.Publisher;
import com.bp.dao.entity.Title;
import com.bp.dao.entity.TitleAuthor;
import com.bp.model.AuthorDTO;
import com.bp.model.PublisherDTO;
import com.bp.model.TitleAuthorDTO;
import com.bp.model.TitleDTO;

@SpringBootTest
class TitleAuthorServiceImplTest {

    @Mock
    private TitleAuthorRepository titleAuthorRepository;

    @InjectMocks
    private TitleAuthorServiceImpl titleAuthorService;

    @Test
    void testAddNewTitleAuthor() {
        // Arrange
        TitleAuthorDTO titleAuthorDTO = createSampleTitleAuthorDTO();
        TitleAuthor titleAuthorEntity = createSampleTitleAuthor();

        when(titleAuthorRepository.save(titleAuthorEntity)).thenReturn(titleAuthorEntity);

        // Act
        String result = titleAuthorService.addNewTitleAuthor(titleAuthorDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Record Created Successfully", result);

     // Verify that the repository method was called with any instance
        verify(titleAuthorRepository).save(any());
    }

    private TitleAuthorDTO createSampleTitleAuthorDTO() {
        TitleAuthorDTO titleAuthorDTO = new TitleAuthorDTO();
        titleAuthorDTO.setId(1L);
        titleAuthorDTO.setAuOrd(1);
        titleAuthorDTO.setRoyaltyPer(60);

        titleAuthorDTO.setTitle(createSampleTitleDTO());
        titleAuthorDTO.setAuthor(createSampleAuthorDTO());

        return titleAuthorDTO;
    }

    private TitleAuthor createSampleTitleAuthor() {
        TitleAuthor titleAuthorEntity = new TitleAuthor();
        titleAuthorEntity.setId(1L);
        titleAuthorEntity.setAuOrd(1);
        titleAuthorEntity.setRoyaltyPer(60);

        titleAuthorEntity.setTitle(createSampleTitleEntity());
        titleAuthorEntity.setAuthor(createSampleAuthorEntity());

        return titleAuthorEntity;
    }

    private TitleDTO createSampleTitleDTO() {
        TitleDTO titleDTO = new TitleDTO();
        titleDTO.setId(1L);
        titleDTO.setTitle("Sample Title");
        titleDTO.setType("Sample Type");
        titleDTO.setPrice(20);
        titleDTO.setAdvance(5000);
        titleDTO.setRoyalty(10);
        titleDTO.setYtdSales(3000);
        titleDTO.setNotes("Sample notes about the title");
        titleDTO.setPubdate("01-01-2022");

        PublisherDTO publisherEntity = new PublisherDTO();
        publisherEntity.setId(1L);
        publisherEntity.setName("Sample Publisher");

        titleDTO.setPublisher(publisherEntity);

        return titleDTO;
    }

    private AuthorDTO createSampleAuthorDTO() {
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setId(1L);
        authorDTO.setFirstName("Sample First Name");
        authorDTO.setLastName("Sample Last Name");
        authorDTO.setPhone("123-456-7890");
        authorDTO.setState("Sample State");
        authorDTO.setZip("12345");

        return authorDTO;
    }

    private Title createSampleTitleEntity() {
        Title titleEntity = new Title();
        titleEntity.setId(1L);
        titleEntity.setTitle("Sample Title");
        titleEntity.setType("Sample Type");
        titleEntity.setPrice(20);
        titleEntity.setAdvance(5000);
        titleEntity.setRoyalty(10);
        titleEntity.setYtdSales(3000);
        titleEntity.setNotes("Sample notes about the title");
        titleEntity.setPubdate("01-01-2022");

        Publisher publisherEntity = new Publisher();
        publisherEntity.setId(1L);
        publisherEntity.setName("Sample Publisher");

        titleEntity.setPublisher(publisherEntity);

        return titleEntity;
    }

    private Author createSampleAuthorEntity() {
        Author authorEntity = new Author();
        authorEntity.setId(1L);
        authorEntity.setFirstName("Sample First Name");
        authorEntity.setLastName("Sample Last Name");
        authorEntity.setPhone("123-456-7890");
        authorEntity.setState("Sample State");
        authorEntity.setZip("12345");

        return authorEntity;
    }
}
