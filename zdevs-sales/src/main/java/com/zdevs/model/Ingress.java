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
public class Ingress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idIngress;

    @ManyToOne//(fk)
    @JoinColumn(name = "id_provider", nullable = false, foreignKey = @ForeignKey(name = "FK_INGRESS_PROVIDER"))
    private Provider provider;
    @ManyToOne//(fk)
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_INGRESS_USER"))
    private User user;

    @Column(length = 50, nullable = false)
    private LocalDateTime dateTime;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double total;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double tax;

    @Column(nullable = false)
    private boolean enabled;

}
