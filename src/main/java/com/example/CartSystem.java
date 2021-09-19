package com.example;

public class CartSystem extends TheSystem {
     CartSystem() {
    }
   
    
    @Override
    public void display() {
        Double sub_total = 0.0;
       
        System.out.println("Cart:");
        System.out.printf("%-20s %-20s %-10s %-10s %-10s\n", "Name", "Description", "Price", "Quantity", "Sub Total");
        for(Item iteratorItem: itemCollection.values()) {
            sub_total += (iteratorItem.getQuantity() * iteratorItem.getItemPrice());
            System.out.printf("%-20s %-20s %-10.2f %-10d %-10.2f\n", iteratorItem.getItemName(), iteratorItem.getItemDesc(), iteratorItem.getItemPrice(), iteratorItem.getQuantity(), iteratorItem.getQuantity() * iteratorItem.getItemPrice());
        }

        Double tax = sub_total * 0.05;
        Double total = sub_total +tax;
        //[Pre-tax Total 0.00 Tax 0.00 Total ] 0.00
        System.out.printf("%-20s %-20.2f\n", "Pre-tax Total", sub_total);
        System.out.printf("%-20s %-20.2f\n", "Tax", tax);
        System.out.printf("%-20s %-20.2f\n", "Total", total);
    }

}
