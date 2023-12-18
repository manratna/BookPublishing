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
public class SaleDTO {
	
	@NotNull
    private StoreDTO store;
    private Long orderNumber;
	@NotNull
    private String orderDate;
	@NotNull
    private Integer qty;
	@NotNull
    private String payterms;
	@NotNull
    private TitleDTO title;
}

