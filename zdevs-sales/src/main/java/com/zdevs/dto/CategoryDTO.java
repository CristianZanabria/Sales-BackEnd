package com.zdevs.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Max;
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
public class CategoryDTO {

    private Integer idCategory;
    @NotNull
    @NotEmpty
    @Size(min = 3,max = 50, message = " name min 3")
    private String nameOfCategory;
    @NotNull
    @NotEmpty
    @Size(min = 3,max = 50)
    private String descriptionCategory;

    @NotNull
    private boolean enabledCategory;
}
