package com.bp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.bp.dao.AuthorRepository;
import com.bp.dao.entity.Author;
import com.bp.model.AuthorDTO;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AuthorServiceImplTest {
	
	@Mock
	private AuthorRepository authorRepository;
	
	@InjectMocks
	private AuthorServiceImpl authorServiceImpl;
	
	private List<Author> createSampleAuthorDTO() {
		List<Author> authors = new ArrayList<>();
		
		Author author1 = new Author();
		author1.setId(1L);
		author1.setLastName("J.K.");
		author1.setFirstName("Rowling");
		author1.setPhone("9010328761");
		author1.setAddress("Killiechassie House");
		author1.setCity("Edinburgh,");
		author1.setState("She primarily resides in Scotland");	
		author1.setZip("534201");
		author1.setContract(true);
		
		authors.add(author1);
		
		
		Author author2 = new Author();
		author2.setId(1L);
		author2.setLastName("Stephen");
		author2.setFirstName(" King");
		author2.setPhone("9010328762");
		author2.setAddress("Bangor ");
		author2.setCity("Maine,");
		author2.setState("USA");	
		author2.setZip("534202");
		author2.setContract(true);
		
		authors.add(author2);
		
		
		
		Author author3 = new Author();
		author3.setId(1L);
		author3.setLastName("Jane");
		author3.setFirstName(" Austen");
		author3.setPhone("9010328763");
		author3.setAddress("Hampshire ");
		author3.setCity("Maine,");
		author3.setState(" England");	
		author3.setZip("534203");
		author3.setContract(true);
		
		authors.add(author3);
		
		
		Author author4 = new Author();
		author4.setId(1L);
		author4.setLastName("Charles");
		author4.setFirstName("  Dickens");
		author4.setPhone("9010328764");
		author4.setAddress("Hamsp ");
		author4.setCity("London");
		author4.setState(" Englandd");	
		author4.setZip("534204");
		author4.setContract(true);
		
		authors.add(author4);
		
		

		Author author5 = new Author();
		author5.setId(1L);
		author5.setLastName("George");
		author5.setFirstName("  Orwell");
		author5.setPhone("9010328765");
		author5.setAddress("Hamspv ");
		author5.setCity("Londonnn");
		author5.setState(" Englanddd");	
		author5.setZip("534205");
		author5.setContract(true);
		
		authors.add(author5);
		
		
		Author author6 = new Author();
		author6.setId(1L);
		author6.setLastName("Mark ");
		author6.setFirstName("  Twain:");
		author6.setPhone("9010328766");
		author6.setAddress("Missouri ");
		author6.setCity("Connecticut");
		author6.setState("  Hartford");	
		author6.setZip("534206");
		author6.setContract(true);
		
		authors.add(author6);
		
		Author author7 = new Author();
		author7.setId(1L);
		author7.setLastName("Ernest ");
		author7.setFirstName("  Hemingway");
		author7.setPhone("9010328767");
		author7.setAddress("Oak Park ");
		author7.setCity("Illinois,");
		author7.setState(" Florida");	
		author7.setZip("534207");
		author7.setContract(true);
		
		authors.add(author7);
		
		Author author8 = new Author();
		author8.setId(1L);
		author8.setLastName("Leo");
		author8.setFirstName("  Tolstoy");
		author8.setPhone("9010328768");
		author8.setAddress("Moscow ");
		author8.setCity("lived in various places in Russia");
		author8.setState(" Russiaa");	
		author8.setZip("534208");
		author8.setContract(true);
		
		authors.add(author8);
		
		
		Author author9 = new Author();
		author9.setId(1L);
		author9.setLastName("Charlotte");
		author9.setFirstName("   Brontë");
		author9.setPhone("9010328769");
		author9.setAddress(" Haworth ");
		author9.setCity("Yorkshire");
		author9.setState(" Englandddd");	
		author9.setZip("534209");
		author9.setContract(true);
		
		authors.add(author9);
		
		Author author10 = new Author();
		author10.setId(1L);
		author10.setLastName("Osca");
		author10.setFirstName("   Wilde");
		author10.setPhone("9010328710");
		author10.setAddress("Dublin ");
		author10.setCity("Ireland");
		author10.setState("  Londonn");	
		author10.setZip("534210");
		author10.setContract(true);
		
		authors.add(author10);
		
		return authors;
	}
	
	

	@Test
		void testGetAllAuthors() {
			List<Author> authors = new ArrayList<>();
			authors.addAll(createSampleAuthorDTO());
			when(authorRepository.findAll()).thenReturn(createSampleAuthorDTO());
			
			List<AuthorDTO> result = authorServiceImpl.getAllAuthors();
			
			assertEquals(result.get(0).getFirstName(), authors.get(0).getFirstName());
			assertNotNull(result);
			assertEquals(10, result.size());
		}

		

		@Test
		void testGetAuthorsByLastName() {
		    // Arrange
		    String lastNameToSearch = "J.K.";
		   
		    
		    when(authorRepository.findByLastName(lastNameToSearch)).thenReturn(createSampleAuthorDTO());

		    // Act
		    List<AuthorDTO> result = authorServiceImpl.getAuthorsByLastName(lastNameToSearch);

		    // Assert
		    assertNotNull(result);
		    assertEquals(10, result.size());
		    assertEquals(lastNameToSearch.trim(), result.get(0).getLastName().trim());
		}

	@Test
	void testGetAuthorsByFirstName() {
		//Arrange
		String firstNameToSearch = "Rowling";
		
		 
	    when(authorRepository.findByFirstName(firstNameToSearch)).thenReturn(createSampleAuthorDTO());

	    // Act
	    List<AuthorDTO> result = authorServiceImpl.getAuthorsByFirstName(firstNameToSearch);

	    // Assert
	    assertNotNull(result);
	    assertEquals(10, result.size());
	    assertEquals(firstNameToSearch.trim(), result.get(0).getFirstName().trim());
	}
	
	@Test
	void testGetAuthorsByPhone() {
	    String phoneToSearch = "9010328761";

	    List<Author> authors = createSampleAuthorDTO();
	    Author authorWithPhone = authors.stream()
	            .filter(author -> author.getPhone().equals(phoneToSearch.trim()))
	            .findFirst().orElse(null);

	    when(authorRepository.findByPhone(phoneToSearch)).thenReturn(authorWithPhone);

	    // Act
	    AuthorDTO result = authorServiceImpl.getAuthorsByPhone(phoneToSearch);

	    // Assert
	    assertNotNull(result);
	    assertEquals("J.K.", result.getLastName());
	    assertEquals("Rowling", result.getFirstName());
	    assertEquals(phoneToSearch.trim(), result.getPhone());
	}




	@Test
	void testGetAuthorsByZip() {	
		// Arrange
	    String zipToSearch = "534201";
	   
	    
	    when(authorRepository.findByZip(zipToSearch)).thenReturn(createSampleAuthorDTO());

	    // Act
	    List<AuthorDTO> result = authorServiceImpl.getAuthorsByZip(zipToSearch);

	    // Assert
	    assertNotNull(result);
	    assertEquals(10, result.size());
	    assertEquals(zipToSearch.trim(), result.get(0).getZip().trim());
		
	}

	@Test
	void testGetAuthorsByState() {
		
		// Arrange
	    String stateToSearch = "She primarily resides in Scotland";
	   
	    
	    when(authorRepository.findByState(stateToSearch)).thenReturn(createSampleAuthorDTO());

	    // Act
	    List<AuthorDTO> result = authorServiceImpl.getAuthorsByState(stateToSearch);

	    // Assert
	    assertNotNull(result);
	    assertEquals(10, result.size());
	    assertEquals(stateToSearch.trim(), result.get(0).getState().trim());
		
	}

	@Test
	void testGetAuthorsByCity() {
		
		// Arrange
	    String cityToSearch = "Edinburgh,";
	   
	    
	    when(authorRepository.findByCity(cityToSearch)).thenReturn(createSampleAuthorDTO());

	    // Act
	    List<AuthorDTO> result = authorServiceImpl.getAuthorsByCity(cityToSearch);

	    // Assert
	    assertNotNull(result);
	    assertEquals(10, result.size());
	    assertEquals(cityToSearch.trim(), result.get(0).getCity().trim());
		
		
	}
	
	@Test
	void testGetAuthorsByName() {
		//Arrange
		String nameToSearch = "Rowling";
		
		 
	    when(authorRepository.findByFirstName(nameToSearch)).thenReturn(createSampleAuthorDTO());

	    // Act
	    List<AuthorDTO> result = authorServiceImpl.getAuthorsByFirstName(nameToSearch);

	    // Assert
	    assertNotNull(result);
	    assertEquals(10, result.size());
	    assertEquals(nameToSearch.trim(), result.get(0).getFirstName().trim());
	}
}