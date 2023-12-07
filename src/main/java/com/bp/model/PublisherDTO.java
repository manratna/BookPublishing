package com.bp.model;

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
    private String name;
    private String city;
    private String state;
    private String country;
	@Override
	public String toString() {
		return "PublisherDTO [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", country="
				+ country + "]";
	}
    
}

