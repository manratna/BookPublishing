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
import com.bp.exception.WrongInputException;
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
    public List<SaleDTO> getAllSales() throws WrongInputException{
        List<SaleDTO> sales = saleRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        if (sales.isEmpty()) {
            throw new WrongInputException("NO data Available in Sales");
        }
        return sales;
    }

    @Override
    public SaleDTO getSaleByOrderNumber(Long orderNumber) throws WrongInputException{
        return saleRepository.findById(orderNumber).map(this::convertToDTO)
                .orElseThrow(() -> new WrongInputException("No Sales Available with given order number"));
    }

    @Override
    public List<SaleDTO> getSalesByTitleId(Long titleId) throws WrongInputException{
        List<SaleDTO> sales = saleRepository.findByTitleId(titleId).stream().map(this::convertToDTO)
                .collect(Collectors.toList());
        if (sales.isEmpty()) {
            throw new WrongInputException("No Sales Available with given title id");
        }
        return sales;
    }

    @Override
    public List<SaleDTO> getSalesByOrderDate(String orderDate) throws WrongInputException{
        List<SaleDTO> sales = saleRepository.findByOrderDate(orderDate).stream().map(this::convertToDTO)
                .collect(Collectors.toList());
        if (sales.isEmpty()) {
            throw new WrongInputException("No Sales Available in the given order date");
        }
        return sales;
    }

    @Override
    public List<SaleDTO> getSalesByStoreId(Long storeId) throws WrongInputException{
        List<SaleDTO> sales = saleRepository.findByStoreId(storeId).stream().map(this::convertToDTO)
                .collect(Collectors.toList());
        if (sales.isEmpty()) {
            throw new WrongInputException("No Sales Available with given store id");
        }
        return sales;
    }

    private SaleDTO convertToDTO(Sale sale) {
        SaleDTO saleDTO = new SaleDTO();
        copyProperties(sale, saleDTO);
        return saleDTO;
    }

    private Sale copyProperties(SaleDTO source, Sale target) {
        if (source != null && target != null) {
            BeanUtils.copyProperties(source, target);

            StoreDTO sourceStore = source.getStore();
            if (sourceStore != null) {
                Store store = new Store();
                BeanUtils.copyProperties(sourceStore, store);
                target.setStore(store);
            }

            TitleDTO sourceTitle = source.getTitle();
            if (sourceTitle != null) {
                Title title = new Title();
                BeanUtils.copyProperties(sourceTitle, title);

                PublisherDTO sourcePublisher = sourceTitle.getPublisher();
                if (sourcePublisher != null) {
                    Publisher publisher = new Publisher();
                    BeanUtils.copyProperties(sourcePublisher, publisher);
                    title.setPublisher(publisher);
                }

                target.setTitle(title);
            }
        }

        return target;
    }

    private SaleDTO copyProperties(Sale source, SaleDTO target) {
        if (source != null && target != null) {
            BeanUtils.copyProperties(source, target);

            Store sourceStore = source.getStore();
            if (sourceStore != null) {
                StoreDTO storeDTO = new StoreDTO();
                BeanUtils.copyProperties(sourceStore, storeDTO);
                target.setStore(storeDTO);
            }

            Title sourceTitle = source.getTitle();
            if (sourceTitle != null) {
                TitleDTO titleDTO = new TitleDTO();
                BeanUtils.copyProperties(sourceTitle, titleDTO);

                Publisher sourcePublisher = sourceTitle.getPublisher();
                if (sourcePublisher != null) {
                    PublisherDTO publisherDTO = new PublisherDTO();
                    BeanUtils.copyProperties(sourcePublisher, publisherDTO);
                    titleDTO.setPublisher(publisherDTO);
                }

                target.setTitle(titleDTO);
            }
        }

        return target;
    }

}
