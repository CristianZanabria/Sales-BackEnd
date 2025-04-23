package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class TaxPayer {

    private String name;
    private Double yearIncome;


    public abstract double calculateTaxes();
}
