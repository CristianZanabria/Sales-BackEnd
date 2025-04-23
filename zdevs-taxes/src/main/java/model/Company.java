package model;

import lombok.Getter;

@Getter
public class Company  extends TaxPayer{

    private Integer numberOfEmployees;

    public Company(String name, Double yearIncome, Integer numberOfEmployees){
         super(name, yearIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double calculateTaxes() {
       if(getNumberOfEmployees() > 10){
           return getYearIncome() * 0.14;
       }else{
           return getYearIncome() * 0.16;
       }
    }
}
