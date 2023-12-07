// SaleService.java

package com.bp.service;

import java.util.List;

import com.bp.model.SaleDTO;

public interface SaleService {
    String addSale(SaleDTO saleDTO);

    List<SaleDTO> getAllSales();

    SaleDTO getSaleByOrderNumber(Long orderNumber);

    List<SaleDTO> getSalesByTitleId(Long titleId);

    List<SaleDTO> getSalesByOrderDate(String orderDate);

    List<SaleDTO> getSalesByStoreId(Long storeId);
}
