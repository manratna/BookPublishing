package com.bp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bp.dao.StoreRepository;
import com.bp.dao.entity.Store;
import com.bp.model.StoreDTO;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
    private StoreRepository storeRepository;
    
    @Override
    public String addNewStore(StoreDTO storeDTO) {
        Store store = new Store();
        try {
            BeanUtils.copyProperties(storeDTO, store);
            storeRepository.save(store);
            return "Record Created Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error Creating Record";
        }
    }

    @Override
    public List<StoreDTO> getAllStores() {
        List<StoreDTO> storeDTOs = storeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return storeDTOs;
    }

    @Override
    public List<StoreDTO> searchStoresByName(String name) {
        List<Store> stores = storeRepository.findByName(name);
        return stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StoreDTO> searchStoresByCity(String city) {
        List<Store> stores = storeRepository.findByCity(city);
        return stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<StoreDTO> searchStoresByZip(String zip) {
        List<Store> stores = storeRepository.findByZip(zip);
        return stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StoreDTO getStoreById(Long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        return storeOptional.map(this::convertToDTO).orElse(null);
    }

    @Override
    public void updateStoreDetails(Long id, StoreDTO storeDTO) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        storeOptional.ifPresent(store -> {
            try {
                BeanUtils.copyProperties(storeDTO, store);
                storeRepository.save(store);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        });
    }

    @Override
    public void updateWholeStoreInfo(Long id, StoreDTO storeDTO) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        storeOptional.ifPresent(store -> {
            try {
                BeanUtils.copyProperties(storeDTO, store);
                storeRepository.save(store);
            } catch (Exception e) {
                e.printStackTrace();
                // Handle the exception as needed
            }
        });
    }

    private StoreDTO convertToDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        try {
            BeanUtils.copyProperties(store, storeDTO);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return storeDTO;
    }
}
