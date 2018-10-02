package com.revature;

import java.util.Random;

class Store { 
    Thread cart1 = new Thread(ShoppingCart());
    Thread cart2 = new Thread(ShoppingCart());

    cart1.start();
    cart2.start();
}