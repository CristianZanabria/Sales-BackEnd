package app;

import model.Customer;
import model.Product;

public class Program {
    public static void main(String[] args) {
       /* Product product = new Product(1, "tv", 99);
       // Product product2 = new Product(1, "tv", 99);

        // System.out.println(product.equals(product2));*/

        Customer c1 = new Customer(1, "Zdevs", true);
        Customer c2 = Customer.builder().idCustomer(1).name("cristian").isActive(false).build();

        Customer.CustomerBuilder c3 = Customer.builder().idCustomer(1);
        Customer c4 = Customer.create(1,"cris");
        if(3 == 5){
            c3.name("default name!");
        }else{
            c3.name("cristian");
        }

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

    }
}
