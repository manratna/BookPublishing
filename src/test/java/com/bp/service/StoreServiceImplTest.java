package com.bp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bp.dao.StoreRepository;
import com.bp.dao.entity.Store;
import com.bp.exception.StoreNotFoundException;
import com.bp.model.StoreDTO;
@SpringBootTest
class StoreServiceImplTest {
	
	@Mock
	private StoreRepository storeRepository;
	
	@InjectMocks
	private StoreServiceImpl storeserviceImpl;

	
	 private List<Store> createSampleStoreDTO() {
		 List<Store> stores = new ArrayList<>();
		 Store store1 = new Store();
	        store1.setId(1L);
	        store1.setName("\"Books & Beyond\"");
	        store1.setAddress("v123 Main Street");
	        store1.setCity("Springfield");
	        store1.setState("IL");
	        store1.setZip("62701");
	        
	        stores.add(store1);
	        
	        Store store2 = new Store();
	        store2.setId(2L);
	        store2.setName("Tech Haven ");
	        store2.setAddress(" 456 Tech Avenue");
	        store2.setCity("Techville");
	        store2.setState("CA ");
	        store2.setZip(" 90210");
	        
	        stores.add(store2);
	        
	        Store store3 = new Store();
	        store3.setId(3L);
	        store3.setName("Home Essentials");
	        store3.setAddress(" 567 Home Lane");
	        store3.setCity(" Homeland");
	        store3.setState(" TX");
	        store3.setZip("75001 ");
	        
	        stores.add(store3);
	        
	        Store store4 = new Store();
	        store4.setId(4L);
	        store4.setName("Fashion Galore ");
	        store4.setAddress(" 789 Fashion Boulevard");
	        store4.setCity("Chic City ");
	        store4.setState("NY ");
	        store4.setZip("100001 ");
	        
	        stores.add(store4);
	        
	        Store store5 = new Store();
	        store5.setId(5L);
	        store5.setName(" ");
	        store5.setAddress(" ");
	        store5.setCity(" ");
	        store5.setState(" ");
	        store5.setZip(" ");
	        
	        stores.add(store5);
	        
	        Store store6 = new Store();
	        store6.setId(6L);
	        store6.setName("Sports Haven");
	        store6.setAddress("234 Sports Road");
	        store6.setCity("Athletic City");
	        store6.setState("AZ");
	        store6.setZip("85001");
	        
	        
	        stores.add(store6);
	        
	        
	        Store store7 = new Store();
	        store7.setName("Pet Paradise");
	        store7.setAddress("654 Pet Avenue");
	        store7.setCity("Petland");
	        store7.setState("GA");
	        store7.setZip("30301");
	        
	        
	        stores.add(store7);
	        
	        Store store8 = new Store();
	        store8.setName("Electronics Universe");
	        store8.setAddress("987 Tech Street");
	        store8.setCity("Techtopia");
	        store8.setState("CA");
	        store8.setZip("95101");
	        
	        stores.add(store8);
	       
	        Store store9 = new Store();
	        store9.setId(9L);
	        store9.setName("Outdoor Adventures");
	        store9.setAddress("321 Nature Lane");
	        store9.setCity("Outdoorsville");
	        store9.setState("CO");
	        store9.setZip("80201");
	        
	        
	        stores.add(store9);
			return stores;
	 }
	 
	 

	@Test
	void testGetAllStores() {
		List<Store> stores = new ArrayList<>();
        stores.addAll(createSampleStoreDTO());
        when(storeRepository.findAll()).thenReturn(createSampleStoreDTO());

        List<StoreDTO> result = storeserviceImpl.getAllStores();

        assertNotNull(result);
        assertEquals(9, result.size());

        assertEquals(result.get(0).getId(), stores.get(0).getId());
        assertEquals(result.get(0).getName(), stores.get(0).getName());
    }
	

	@Test
	void testSearchStoresByName() {
		 String nameToSearch = "YourStoreName"; 
	        List<Store> stores = new ArrayList<>();
	        stores.addAll(createSampleStoreDTO());
	        when(storeRepository.findByName(nameToSearch)).thenReturn(createSampleStoreDTO());

	        List<StoreDTO> result = storeserviceImpl.searchStoresByName(nameToSearch);

	        assertNotNull(result);
	        assertEquals(9, result.size());

	        assertEquals(result.get(0).getId(), stores.get(0).getId());
	        assertEquals(result.get(0).getName(), stores.get(0).getName());
	      
	    }

	@Test
	void testSearchStoresByCity() {
		String cityToSearch = "YourCity";
        List<Store> stores = new ArrayList<>();
        stores.addAll(createSampleStoreDTO());
        when(storeRepository.findByCity(cityToSearch)).thenReturn(createSampleStoreDTO());

        List<StoreDTO> result = storeserviceImpl.searchStoresByCity(cityToSearch);

        assertNotNull(result);
        assertEquals(9, result.size());

        assertEquals(result.get(0).getId(), stores.get(0).getId());
        assertEquals(result.get(0).getName(), stores.get(0).getName());
		
	}
	
	@Test
	void testGetStoreById() {
		Long storeIdToSearch = 1L; 
        Store store = createSampleStoreDTO().get(0);
        when(storeRepository.findById(storeIdToSearch)).thenReturn(Optional.of(store));

        StoreDTO result = storeserviceImpl.getStoreById(storeIdToSearch);

        assertNotNull(result);
        assertEquals(store.getId(), result.getId());
        assertEquals(store.getName(), result.getName());
		
	}
	
	@Test
	void testSearchStoresByZip() {
		String zipToSearch = "YourZip"; 
        List<Store> stores = new ArrayList<>();
        stores.addAll(createSampleStoreDTO());
        when(storeRepository.findByZip(zipToSearch)).thenReturn(createSampleStoreDTO());

        List<StoreDTO> result = storeserviceImpl.searchStoresByZip(zipToSearch);

        assertNotNull(result);
        assertEquals(9, result.size());

      
        assertEquals(result.get(0).getId(), stores.get(0).getId());
        assertEquals(result.get(0).getName(), stores.get(0).getName());
     
    }
	
	@Test
	void testSearchStoresByName1() {
		 String nameToSearch = "YourStoreName"; // Replace with the desired store name
	        List<Store> stores = new ArrayList<>();
	        stores.addAll(createSampleStoreDTO());
	        when(storeRepository.findByName(nameToSearch)).thenReturn(createSampleStoreDTO());

	        List<StoreDTO> result = storeserviceImpl.searchStoresByName(nameToSearch);

	        assertNotNull(result);
	        assertEquals(9, result.size());

	        assertEquals(result.get(0).getId(), stores.get(0).getId());
	        assertEquals(result.get(0).getName(), stores.get(0).getName());
	      
	    }
	
	@Test
	void testGetAllStoresException() {
		
		 when(storeRepository.findAll()).thenReturn(new ArrayList<>());

	 
	        StoreNotFoundException exception = assertThrows(StoreNotFoundException.class, () -> storeserviceImpl.getAllStores());
	        String expectedMessage = "No Stores available";
	        String actualMessage = exception.getMessage();
	        assertEquals(expectedMessage, actualMessage);
	}
	
	
}
	
	
	



