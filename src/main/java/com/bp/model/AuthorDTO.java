package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long id;
    private String lastName;
    private String firstName;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zip;
    private boolean contract;
}

