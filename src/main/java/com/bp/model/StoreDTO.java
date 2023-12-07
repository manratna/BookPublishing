package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
}

