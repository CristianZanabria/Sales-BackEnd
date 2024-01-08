package com.zdevs.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Integer idUser;

    @JsonIncludeProperties(value = {"idRole","nameRole"})
    @NotNull
    private RoleDTO role;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String userName;

    @NotNull
    @NotEmpty
    @Size(min = 8, max = 80)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    private boolean enabled;
}
