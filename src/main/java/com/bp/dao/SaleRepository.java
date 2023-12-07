// SaleRepository.java

package com.bp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bp.dao.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findByTitleId(Long titleId);

    List<Sale> findByOrderDate(String orderDate);

    List<Sale> findByStoreId(Long storeId);

    // Additional custom queries can be added here if needed
}
