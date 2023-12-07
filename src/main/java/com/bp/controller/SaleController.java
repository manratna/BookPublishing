package com.bp.controller;

import com.bp.model.SaleDTO;
import com.bp.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

 @Autowired
 private SaleService saleService;

 @PostMapping
 public String addSale(@RequestBody SaleDTO saleDTO) {
     return saleService.addSale(saleDTO);
 }

 @GetMapping
 public List<SaleDTO> getAllSales() {
     return saleService.getAllSales();
 }

 @GetMapping("/{id}")
 public SaleDTO getSaleByOrderNumber(@PathVariable Long id) {
     return saleService.getSaleByOrderNumber(id);
 }

 @GetMapping("/titleid/{id}")
 public List<SaleDTO> getSalesByTitleId(@PathVariable Long id) {
     return saleService.getSalesByTitleId(id);
 }

 @GetMapping("/orderdate/{orderdate}")
 public List<SaleDTO> getSalesByOrderDate(@PathVariable String orderdate) {
     return saleService.getSalesByOrderDate(orderdate);
 }

 @GetMapping("/storid/{id}")
 public List<SaleDTO> getSalesByStoreId(@PathVariable Long id) {
     return saleService.getSalesByStoreId(id);
 }
}
