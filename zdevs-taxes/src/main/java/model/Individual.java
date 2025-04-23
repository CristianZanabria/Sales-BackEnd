package model;

import lombok.Getter;

@Getter
public class Individual extends TaxPayer{
    private  Double healthExpenditures;

    public  Individual(String name, Double yearIncome, Double healthExpenditures){
        super(name,yearIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double calculateTaxes() {

        double basicTax;
        if (getYearIncome() < 20000){
            basicTax = getYearIncome() * 0.15;
        }else{
            basicTax = getYearIncome() * 0.25;
        }
        basicTax -= getHealthExpenditures() * 0.5;

        if (basicTax < 0){
            basicTax = 0;
        }
        return basicTax;
    }
}
