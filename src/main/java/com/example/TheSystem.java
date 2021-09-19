package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public abstract class TheSystem {
   
    protected HashMap<String, Item> itemCollection;
    Scanner scan;
    
    TheSystem() {
        itemCollection = new HashMap<String, Item>();
        
        if (getClass().getSimpleName().equals("AppSystem")) {
            File file = new File("resources/sample.txt");
            
            try {
                scan = new Scanner(file);
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String[] itemInfo = line.split("\\s ");
                Item newItem = new Item(
                        itemInfo[0], itemInfo[1], Double.parseDouble(itemInfo[2]), Integer.parseInt(itemInfo[3]));
                
                itemCollection.put(newItem.getItemName(), newItem);
            }
        }
    }
    
    public HashMap<String, Item> getItemCollection(){
        return itemCollection;
    }
     public void setItemCollection(HashMap<String, Item> itemCollection) {
        this.itemCollection = itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
        if(item.getQuantity() >= item.getAvailableQuantity()){
            System.out.println("System is unable to add "+item.getItemName()+" to the card. System only has "+item.getAvailableQuantity()+" "+item.getItemName()+"s");
            return false;
        }
        return true;
    }
    
    
    public Boolean add(Item item) {
        if(item == null){
            return false;
        } 
        boolean exists = false;
        
        for(Item iteratorItem: itemCollection.values()) {
            if (iteratorItem.getItemName() == item.getItemName()) {
                exists = true;
                if (iteratorItem.getAvailableQuantity() >= item.getQuantity()) {
                    iteratorItem.setQuantity(iteratorItem.getQuantity() + 1);
                    return true;
                }
            }
        }
        
        if (!exists) {
            itemCollection.put(item.getItemName(), item);
            return true;
        }
        
        return false;
    }

    
    public Item remove(String itemName) {
        // Your code here
        boolean exists = false;
        Item existingItem = null;
        
        for(Item iteratorItem: itemCollection.values()) {
            if (iteratorItem.getItemName().equals(itemName)) {
                exists = true;
                existingItem = iteratorItem;
            }
        }
        
        if (exists) {
            itemCollection.remove(itemName, existingItem);
        }
        return existingItem;
    }

    public abstract void display();


}