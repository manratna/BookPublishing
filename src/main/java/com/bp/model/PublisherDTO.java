package com.bp.model;

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
	@NotNull
    private Long id;
	@NotNull
    private String name;
	@NotNull
    private String city;
	@NotNull
    private String state;
	@NotNull
    private String country;
	@Override
	public String toString() {
		return "PublisherDTO [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
    
}

