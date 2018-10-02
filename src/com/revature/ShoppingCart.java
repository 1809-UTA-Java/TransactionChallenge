package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ShoppingCart extends Thread {
    String fileName = "grocerystore.txt";
    private ArrayList<String> myCollection = new ArrayList<>();;
    /*public ShoppingCart() {
        myCollection = 
    }*/

    public ArrayList<String> getCollection () {
        return myCollection;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(fileName);

        synchronized(this) {

            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            String firstLine = sc.nextLine();
            myCollection.add(firstLine);

            try(FileWriter fw = new FileWriter(fileName, false)) {
                while(sc.hasNextLine()) {
                    fw.write(sc.nextLine());
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
            this.notify();
        }

        sc.close();
    }

}