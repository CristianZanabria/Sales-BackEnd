package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Customer {
    private int idCustomer;
    private String name;
    private boolean isActive;

    public static Customer create(int idCustomer,String name){
        return new Customer(idCustomer,name, true);
    }
}
