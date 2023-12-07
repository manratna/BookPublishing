package com.bp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bp.model.StoreDTO;
import com.bp.service.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {
	
	@Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<String> addNewStore(@RequestBody StoreDTO storeDTO) {
        String result = storeService.addNewStore(storeDTO);
        System.out.println(storeDTO.getAddress()+"controller");
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StoreDTO>> getAllStores() {
        List<StoreDTO> stores = storeService.getAllStores();
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<StoreDTO>> searchStoresByName(@PathVariable String name) {
        List<StoreDTO> stores = storeService.searchStoresByName(name);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<StoreDTO>> searchStoresByCity(@PathVariable String city) {
        List<StoreDTO> stores = storeService.searchStoresByCity(city);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/zip/{zip}")
    public ResponseEntity<List<StoreDTO>> searchStoresByZip(@PathVariable String zip) {
        List<StoreDTO> stores = storeService.searchStoresByZip(zip);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/Id/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id) {
        StoreDTO store = storeService.getStoreById(id);
        if (store != null) {
            return new ResponseEntity<>(store, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updateStoreDetails(@PathVariable Long id, @RequestBody StoreDTO storeDTO) {
        storeService.updateStoreDetails(id, storeDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateWholeStoreInfo(@PathVariable Long id, @RequestBody StoreDTO storeDTO) {
        storeService.updateWholeStoreInfo(id, storeDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
