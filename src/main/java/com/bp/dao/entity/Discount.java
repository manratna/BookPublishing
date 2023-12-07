package com.bp.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "discounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @Column(name = "discount_type")
    private String discountType;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Column(name = "lowqty")
    private Integer lowQty;

    @Column(name = "highqty")
    private Integer highQty;

    @Column(name = "discount", nullable = false)
    private Integer discount;

}
