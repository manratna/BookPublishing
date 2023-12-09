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
public class PublisherInfoDTO {
    private Long id;
    
    @NotNull
    private PublisherDTO publisher;
    @NotNull
    @NotBlank
    private String logo;
    @NotNull
    @NotBlank
    private String prInfo;
}

