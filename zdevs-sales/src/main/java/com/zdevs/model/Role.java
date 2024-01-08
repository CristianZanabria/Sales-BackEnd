package com.zdevs.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Role {
    @Id
    @EqualsAndHashCode.Include
    private Integer idRole;
    @Column(length = 10, nullable = false)
    private String nAME;
    @Column(nullable = false)
    private  Boolean enabled;
}
