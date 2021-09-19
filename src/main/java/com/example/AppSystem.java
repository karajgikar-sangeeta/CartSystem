package com.example;

public class AppSystem extends TheSystem {
    AppSystem() {
        
    }

    @Override
    public void display() {
        System.out.println("AppSystem Inventory:");
        
        System.out.printf("%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");
        
        for(Item iteratorItem: itemCollection.values()) {
            System.out.printf("%-20s %-20s %-10.2f %-10d\n", iteratorItem.getItemName(), iteratorItem.getItemDesc(), iteratorItem.getItemPrice(), iteratorItem.getAvailableQuantity());
        }
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        if (item == null) {
            return false;
        }
        boolean exists = false;
        for(Item iteratorItem : itemCollection.values()) {
            if(iteratorItem.getItemName().equals(item.getItemName())) {
                exists = true;
                break;
            }
        }
        if(exists) {
            System.out.println(String.format("%s is already in the App System", item.getItemName()));
            return false;
        }else {
            itemCollection.put(item.getItemName(),item);
            return true;
        }
    }

    public Item reduceAvailableQuantity(String item_name) {
        Item existingItem = null;
        
        for(Item iteratorItem : itemCollection.values()) {
            if(iteratorItem.getItemName().equals(item_name)) {
                existingItem = iteratorItem;
                break;
            }
        }
        
        if (existingItem != null) {
            existingItem.setAvailableQuantity(existingItem.getAvailableQuantity() - 1);
            if (existingItem.getAvailableQuantity() == 0) {
                itemCollection.remove(item_name, existingItem);
            }
        }
        
        return existingItem;
    }
}