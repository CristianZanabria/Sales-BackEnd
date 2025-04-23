package com.zdevs.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "User_data")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    @ManyToOne//(fk)
    @JoinColumn(name = "id_role", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ROLES"))//fk_Product
    private Role role;

    @Column(name = "username",length = 50, nullable = false,unique = true)
    private String userName;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean enabled;
}
