package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherInfoDTO {
    private Long id;
    private PublisherDTO publisher;
    private String logo;
    private String prInfo;
}

