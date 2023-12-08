package com.bp.model;

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
    private String title;
    private String type;
    private PublisherDTO publisher;
    private Integer price;
    private Integer advance;
    private Integer royalty;
    private Integer ytdSales;
    private String notes;
    private String pubdate;
    
}

