package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ShoppingCart implements Runnable {
    String fileName = "grocerystore.txt";
    ArrayList<String> myCollection = new ArrayList<>();

    @Override
    public void run() {
        Scanner sc = new Scanner(fileName);

        ArrayList<String> myCollection = new ArrayList<>();

        String firstLine = sc.nextLine();
        myCollection.add(firstLine);

        try {
            this.wait();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(fileName, false)) {
            while(sc.hasNextLine()) {
                fw.write(sc.nextLine());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        this.notify();

        sc.close();
    }

}