package com.bp.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO {
	
    private Long id;
	@NotNull
	@NotBlank
    private String name;
	@NotNull
	@NotBlank
    private String city;
	@NotNull
	@NotBlank
    private String state;
	@NotNull
	@NotBlank
    private String country;
	@Override
	public String toString() {
		return "PublisherDTO [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
    
}

