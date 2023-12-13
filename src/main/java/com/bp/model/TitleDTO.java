package com.bp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitleDTO {

    private Long id;
    
    @NotBlank
    private String title;
    
    @NotBlank
    @Size(max = 80)
    private String type;
    
    @NotNull
    private PublisherDTO publisher;
    
    @NotNull
    @Min(0)
    private Integer price;
    
    @NotNull
    @Min(0)
    private Integer advance;
    
    @NotNull
    @Min(0)
    private Integer royalty;
    
    @NotNull
    @Min(0)
    private Integer ytdSales;
    
    private String notes;
    
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String pubdate;
    
    private String imageURLString;
    
}

