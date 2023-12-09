package com.bp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bp.dao.StoreRepository;
import com.bp.dao.entity.Store;
import com.bp.exception.NoDataAvailableException;
import com.bp.exception.NoStoreDataAvailableException;
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
        } catch (NoDataAvailableException e) {
            return "Error Creating Record";
        }
    }

    @Override
    public List<StoreDTO> getAllStores()throws NoStoreDataAvailableException {
         List<StoreDTO> collect = storeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<StoreDTO> searchStoresByName(String name)throws NoStoreDataAvailableException {
        List<Store> stores = storeRepository.findByName(name);
        List<StoreDTO> collect = stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if(collect.isEmpty()) {
			throw new NoStoreDataAvailableException("No Stores Available with this name: "+name);
		}
       
		
		return collect;
    }

    @Override
    public List<StoreDTO> searchStoresByCity(String city)throws NoStoreDataAvailableException {
        List<Store> stores = storeRepository.findByCity(city);
        List<StoreDTO> collect = stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if(collect.isEmpty()) {
			throw new NoStoreDataAvailableException("No Stores Available with this city: "+city);
		}
        
		return collect;
    }

    @Override
    public List<StoreDTO> searchStoresByZip(String zip)throws NoStoreDataAvailableException {
        List<Store> stores = storeRepository.findByZip(zip);
        List<StoreDTO> collect = stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        if(collect.isEmpty()) {
			throw new NoStoreDataAvailableException("No Stores Available with this Zip: "+zip);
		}
		return collect;
    }

    @Override
    public StoreDTO getStoreById(Long id){
        Optional<Store> storeOptional = storeRepository.findById(id);
        StoreDTO orElse = storeOptional.map(this::convertToDTO).orElseThrow(()->new NoStoreDataAvailableException("No Stores Available with this id"+id));
        
		return orElse;
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
