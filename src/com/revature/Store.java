package com.revature;

import java.util.Random;

class Store {
    public static void main(String[] args) {
        Thread cart1 = new Thread(new ShoppingCart());
        Thread cart2 = new Thread(new ShoppingCart());
    
        cart1.start();
        cart2.start();
    } 
}