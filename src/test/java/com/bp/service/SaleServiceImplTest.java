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

import com.bp.dao.SaleRepository;
import com.bp.dao.entity.Sale;
import com.bp.dao.entity.Store;
import com.bp.dao.entity.Title;
import com.bp.exception.WrongInputException;
import com.bp.model.SaleDTO;

@SpringBootTest
class SaleServiceImplTest {
	
	@Mock
    private SaleRepository saleRepository;
	
    @InjectMocks
    private SaleServiceImpl saleServiceImpl;
	
    private List<Sale> createSampleSaleDTO() {
		List<Sale> sales = new ArrayList<>();
		
		Sale sale = new Sale();
		sale.setOrderNumber(1L);
		sale.setPayterms("COD");
		sale.setQty(2);
		sale.setOrderDate("09-14-1993");
		
		Store store = new Store();
		store.setId(11L);
		sale.setStore(store);
		
		Title title = new Title();
		title.setId(10L);
		sale.setTitle(title);
		
		sales.add(sale);
		
		
		
		Sale sale1 = new Sale();
		sale1.setOrderNumber(1L);
		sale1.setPayterms("COD");
		sale1.setQty(3);
		sale1.setOrderDate("01-12/-1990");
		
		Store store1 = new Store();
		store1.setId(8L);
		sale1.setStore(store1);
		
		Title title1 = new Title();
		title1.setId(2L);
		sale1.setTitle(title1);
		
		sales.add(sale1);
		
		
		
		Sale sale2 = new Sale();
		sale2.setOrderNumber(12L);
		sale2.setPayterms("COD");
		sale2.setQty(10);
		sale2.setOrderDate("12-10-2012");
		
		Store store2 = new Store();
		store2.setId(4L);
		sale2.setStore(store2);
		
		Title title2 = new Title();
		title2.setId(1L);
		sale2.setTitle(title2);
		
		sales.add(sale2);
		
		
		
		Sale sale3 = new Sale();
		sale3.setOrderNumber(1L);
		sale3.setPayterms("COD");
		sale3.setQty(10);
		sale3.setOrderDate("15-08-2081");
		
		Store store3 = new Store();
		store3.setId(6L);
		sale3.setStore(store3);
		
		Title title3 = new Title();
		title3.setId(4L);
		sale3.setTitle(title3);
		
		sales.add(sale3);
		
		
		
		Sale sale4 = new Sale();
		sale4.setOrderNumber(1L);
		sale4.setPayterms("COD");
		sale4.setQty(10);
		sale4.setOrderDate("25-07-2011");
		
		Store store4 = new Store();
		store4.setId(44L);
		sale4.setStore(store4);
		
		Title title4 = new Title();
		title4.setId(10L);
		sale4.setTitle(title4);
		
		sales.add(sale4);
		
		
		
		Sale sale5 = new Sale();
		sale5.setOrderNumber(14L);
		sale5.setPayterms("COD");
		sale5.setQty(6);
		sale5.setOrderDate("10-12-1901");
		
		Store store5 = new Store();
		store5.setId(7L);
		sale5.setStore(store5);
		
		Title title5 = new Title();
		title5.setId(5L);
		sale5.setTitle(title5);
		
		sales.add(sale5);
		
		
		
		Sale sale6 = new Sale();
		sale6.setOrderNumber(1L);
		sale6.setPayterms("COD");
		sale6.setQty(5);
		sale6.setOrderDate("16-11-2001");
		
		Store store6 = new Store();
		store6.setId(14L);
		sale6.setStore(store6);
		
		Title title6 = new Title();
		title6.setId(13L);
		sale6.setTitle(title6);
		
		sales.add(sale1);
		
		return sales;
    }
   

	@Test
	void testGetAllSales() {
		List<Sale> sales = new ArrayList<>();
		sales.addAll(createSampleSaleDTO());
		when(saleRepository.findAll()).thenReturn(createSampleSaleDTO());
		
		List<SaleDTO> result = saleServiceImpl.getAllSales();
		
		assertEquals(result.get(0).getQty(), sales.get(0).getQty());
        assertNotNull(result);
        assertEquals(7, result.size());
	}
	
	@Test
    void testGetAllSalesException() {
        
        when(saleRepository.findAll()).thenReturn(new ArrayList<>());

        
        WrongInputException exception = assertThrows(WrongInputException.class, () -> saleServiceImpl.getAllSales());
        String expectedMessage = "NO data Available in Sales";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
	
	@Test
    void testgetSalesByOrderDate() {
        String ordDateToSearch = "09-14-1993";
        when(saleRepository.findByOrderDate(ordDateToSearch)).thenReturn(createSampleSaleDTO().subList(0, 1));

        
        List<SaleDTO> result = saleServiceImpl.getSalesByOrderDate(ordDateToSearch);

                assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(ordDateToSearch, result.get(0).getOrderDate());
    }
	
	@Test
    void testgetSalesByTitleId() {
        
        Long TitleId = 10L;
        when(saleRepository.findByTitleId(TitleId)).thenReturn(createSampleSaleDTO().subList(0, 1));

        List<SaleDTO> result = saleServiceImpl.getSalesByTitleId(TitleId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(TitleId, result.get(0).getTitle().getId());
    }
	
	@Test
    void testgetSalesByStoreId() {
        
        Long storeId = 11L;
        when(saleRepository.findByStoreId(storeId)).thenReturn(createSampleSaleDTO().subList(0, 1));

        List<SaleDTO> result = saleServiceImpl.getSalesByStoreId(storeId);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(storeId, result.get(0).getStore().getId());
    }

}
