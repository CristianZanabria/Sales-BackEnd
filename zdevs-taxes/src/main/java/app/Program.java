package app;

import model.Company;
import model.Individual;
import model.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of tax payer");
        int numberOfTaxpayers = sc.nextInt();

        List<TaxPayer> list = new ArrayList<>();

        for (int i = 1; i <= numberOfTaxpayers; i++){
            System.out.println("Taxpayer #" + i + "data:" );
            System.out.println("Individual or Company  (i/c)?");
            char type = sc.next().charAt(0);

            System.out.println("Name:");
            String name = sc.next();
            System.out.println("Year Income");
            Double yearIncome = sc.nextDouble();

            if (type == 'i'){
                System.out.println("Health Expenditures");
                Double healthExpenditures = sc.nextDouble();
                Individual ind = new Individual(name, yearIncome, healthExpenditures);
                list.add(ind);
            }else{
                System.out.println("Number of employees");
                Integer numberOfEmployees = sc.nextInt();
                Company comp = new Company(name, yearIncome,numberOfEmployees);
                list.add(comp);

            }

        }

        System.out.println("========================================");
        System.out.println("TAXES PAID");

        for (TaxPayer tp : list){
            System.out.println(tp.getName() + " : $" + String.format("%.2f", tp.calculateTaxes()));
        }
        System.out.println("=================================================");

        double sum = 0;
        for (TaxPayer tp : list){
            sum += tp.calculateTaxes();
        }
        System.out.println("TOTAL TAXES: $" + String.format("%.2f", sum));
    }
}
