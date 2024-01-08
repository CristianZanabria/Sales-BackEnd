package com.zdevs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zdevs.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    private Integer idProduct;

    @NotNull
    @Min(1)
    private Integer idOfCategory;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nameProduct;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String descriptionProduct;

    @Min(1)
    private double priceProduct;

    @NotNull
    private boolean enabledProduct;
}
