package com.zdevs.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Embeddable
@EqualsAndHashCode
public class IngressDetailPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_ingress", nullable = false)
    private Ingress ingress;


    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false)
    private Product product;


}
