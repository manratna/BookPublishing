package com.bp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDTO {
    private String discountType;
    private StoreDTO store;
    private Integer lowQty;
    private Integer highQty;
    private Integer discount;
}

