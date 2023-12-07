package com.bp.dao.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ord_num")
    private Long orderNumber;

    @Column(name = "ord_date", nullable = false)
    private String orderDate;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "payterms", nullable = false)
    private String payterms;

    @ManyToOne
    @JoinColumn(name = "title_id")
    private Title title;
}
