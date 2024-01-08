package com.zdevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSaleDetail;
    @ManyToOne
    @JoinColumn(name = "id_sale",nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_SALE"))
    private Sale sale;
    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_PRODUCT"))
    private Product product;

    @Column(nullable = false)
    private short quantity;

    @Column( columnDefinition = "decimal(6,2)",nullable = false)
    private double salePrice;

    @Column( columnDefinition = "decimal(6,2)",nullable = false)
    private double discount;

}
