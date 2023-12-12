package com.bp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

	@NotNull
    private Long id;
	
	@NotNull
	@Size(max =10)
    private String lastName;
	
	@NotBlank
	@Size(max = 20)
    private String firstName;
	
	@NotNull
	@Size(max = 10)
    private String phone;
	
	@NotBlank
	@Size(max = 21)
    private String address;
	
	@NotNull
	@Size(max = 15)
    private String city;
	
	@NotNull
	@Size(max = 14)
    private String state;
	
	@NotNull
	@Size(max = 8)
    private String zip;
	
	@NotNull
    private boolean contract;
}

