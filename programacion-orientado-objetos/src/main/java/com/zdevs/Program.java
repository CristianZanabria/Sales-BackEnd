package com.zdevs;

import com.zdevs.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter client data:");
        System.out.println("Name:");
        String name = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        System.out.println("Birth date: (YYYY-MM-DD");
        String birthdateString = sc.nextLine();
        LocalDate birthDate = LocalDate.parse(birthdateString);

        Client client = new Client(name, email, birthDate);

        System.out.println("Enter order data");
        System.out.println("Status: ");

        OrderStatus status = OrderStatus.valueOf(sc.nextLine());
        Order order = new Order(LocalDateTime.now(), status, client, new ArrayList<>());

        System.out.println("How many items to this order?");

        int numberOfItems = sc.nextInt();

        for (int i = 1; i <= numberOfItems; i++){
            System.out.println("Enter #" + i + " item data");
            System.out.println("Product name : ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.println("Product pr1ce: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName, productPrice);
            OrderItem item = new OrderItem(quantity, productPrice, product);

            order.addItem(item);

        }

        System.out.println("ORDER SUMMARY");
        System.out.println(order);
        sc.close();

    }
}
