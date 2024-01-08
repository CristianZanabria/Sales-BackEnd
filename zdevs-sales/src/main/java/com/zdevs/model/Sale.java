package com.zdevs.model;

import com.zdevs.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SqlResultSetMapping(
        name = "Procedure.procedureDTO",
        classes = @ConstructorResult(targetClass = ProductDTO.class,
                columns = {
                @ColumnResult( name = "quantityfn", type = Integer.class),
                @ColumnResult( name = "datetimefn", type = String.class)
}
        )
)
@NamedNativeQuery(
        name = "Sale.fn_sales",
        query = "Select * from fn_sales()",
        resultSetMapping = "Procedure.procedureDTO"
)

////////////////////////////////


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSale;
    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CLIENT"))
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_USER"))
    private User user;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double total;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double tax;

    @Column(nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleDetail> details;

    //pricipio de la base de datos
    //ACID
    //atomicidad
    //consistencia
    //Aislamiento
    //durabilidad

}
