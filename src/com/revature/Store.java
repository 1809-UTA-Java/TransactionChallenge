package com.revature;

import java.util.Random;

class Store {
    public static void main(String[] args) {
        ShoppingCart cart1 = new ShoppingCart();
        ShoppingCart cart2 = new ShoppingCart();
    
        cart1.start();
        cart2.start();
        
        try {
            cart1.join();
            cart2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(cart1.getCollection().toString());
        System.out.println(cart2.getCollection().toString());
    } 
}