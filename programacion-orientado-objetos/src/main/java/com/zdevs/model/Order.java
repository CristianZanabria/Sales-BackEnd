package com.zdevs.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items;

    public void addItem(OrderItem item){
        items.add(item);
    }
    public double total(){
        double sum =0;
        for (OrderItem it :items){
            sum += it.getPrice() * it.getQuantity();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(moment).append("\n");
        sb.append("Order status: ");
        sb.append(status).append("\n");
        sb.append(client).append("\n");
        sb.append("Order items: ");

        for (OrderItem it : items){
            sb.append(it).append("\n");

        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();

    }
}
