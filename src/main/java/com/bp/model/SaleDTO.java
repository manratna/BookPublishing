package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private StoreDTO store;
    private Long orderNumber;
    private String orderDate;
    private Integer qty;
    private String payterms;
    private TitleDTO title;
}

