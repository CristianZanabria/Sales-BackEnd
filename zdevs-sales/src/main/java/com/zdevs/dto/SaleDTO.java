package com.zdevs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SaleDTO {

    private Integer idSale;

    @NotNull
    private ClientDTO client;

    @NotNull
    private UserDTO user;

    @NotNull
    private LocalDateTime dateTime;

    @Min(value = 1)
    private double total;

    @Min(value = 1)
    private double tax;

    @NotNull
    private boolean enabled;

    @JsonManagedReference
    @NotNull
    private List<SaleDetailDTO> details;
}
