package com.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.SaleDTO;
import com.bp.service.SaleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<String> addSale(@Valid @RequestBody SaleDTO saleDTO) {
        String result = saleService.addSale(saleDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        List<SaleDTO> sales = saleService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getSaleByOrderNumber(@PathVariable Long id) {
        SaleDTO sale = saleService.getSaleByOrderNumber(id);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }

    @GetMapping("/titleid/{id}")
    public ResponseEntity<List<SaleDTO>> getSalesByTitleId(@PathVariable Long id) {
        List<SaleDTO> sales = saleService.getSalesByTitleId(id);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/orderdate/{orderdate}")
    public ResponseEntity<List<SaleDTO>> getSalesByOrderDate(@PathVariable String orderdate) {
        List<SaleDTO> sales = saleService.getSalesByOrderDate(orderdate);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/storid/{id}")
    public ResponseEntity<List<SaleDTO>> getSalesByStoreId(@PathVariable Long id) {
        List<SaleDTO> sales = saleService.getSalesByStoreId(id);
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }
}
