package com.bp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bp.dao.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByName(String name);

    List<Store> findByCity(String city);

    List<Store> findByZip(String zip);
}
