package com.bp.service;

import com.bp.model.StoreDTO;

import java.util.List;

public interface StoreService {

    String addNewStore(StoreDTO storeDTO);

    List<StoreDTO> getAllStores();

    List<StoreDTO> searchStoresByName(String name);

    List<StoreDTO> searchStoresByCity(String city);

    List<StoreDTO> searchStoresByZip(String zip);

    StoreDTO getStoreById(Long id);

    void updateStoreDetails(Long id, StoreDTO storeDTO);

    void updateWholeStoreInfo(Long id, StoreDTO storeDTO);
}
