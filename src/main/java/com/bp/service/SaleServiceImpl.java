// SaleServiceImpl.java

package com.bp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bp.dao.SaleRepository;
import com.bp.dao.entity.Publisher;
import com.bp.dao.entity.Sale;
import com.bp.dao.entity.Store;
import com.bp.dao.entity.Title;
import com.bp.model.PublisherDTO;
import com.bp.model.SaleDTO;
import com.bp.model.StoreDTO;
import com.bp.model.TitleDTO;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public String addSale(SaleDTO saleDTO) {
        Sale sale = new Sale();
        try {
            copyProperties(saleDTO, sale);
            saleRepository.save(sale);
            return "Record Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error Creating Record";
        }
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return saleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO getSaleByOrderNumber(Long orderNumber) {
        return saleRepository.findById(orderNumber)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public List<SaleDTO> getSalesByTitleId(Long titleId) {
        return saleRepository.findByTitleId(titleId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> getSalesByOrderDate(String orderDate) {
        return saleRepository.findByOrderDate(orderDate).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> getSalesByStoreId(Long storeId) {
        return saleRepository.findByStoreId(storeId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SaleDTO convertToDTO(Sale sale) {
        SaleDTO saleDTO = new SaleDTO();
        copyProperties(sale, saleDTO);
        return saleDTO;
    }

    private Sale copyProperties(SaleDTO source, Sale target) {
        BeanUtils.copyProperties(source, target);
        Store store = new Store();
        BeanUtils.copyProperties(source.getStore(), store);
        target.setStore(store);
        Title title = new Title();
        BeanUtils.copyProperties(source.getTitle(), title);
        Publisher publisher = new Publisher();
        BeanUtils.copyProperties(source.getTitle().getPublisher(), publisher);
        title.setPublisher(publisher);
        target.setTitle(title);
        return target;
        

    }

    private SaleDTO copyProperties(Sale source, SaleDTO target) {
        BeanUtils.copyProperties(source, target);
        StoreDTO storeDTO = new StoreDTO();
        BeanUtils.copyProperties(source.getStore(), storeDTO);
        target.setStore(storeDTO);
        TitleDTO titleDTO = new TitleDTO();
        BeanUtils.copyProperties(source.getTitle(), titleDTO);
        PublisherDTO publisherDTO = new PublisherDTO();
        BeanUtils.copyProperties(source.getTitle().getPublisher(), publisherDTO);
        titleDTO.setPublisher(publisherDTO);
        target.setTitle(titleDTO);
        return target;
        
    }
}
