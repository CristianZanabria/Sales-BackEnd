package model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Product {

    @ToString.Include
    @EqualsAndHashCode.Include
    private  int idProduct;

    //@ToString.Include
    //@EqualsAndHashCode.Include
    private String name;
    //@ToString.Exclude
    private double price;

}
