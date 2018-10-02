package com.revature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ShoppingCart implements Runnable {

    String fileName = "grocerystore.txt";

    @Override
    public void run() {
        Scanner sc = new Scanner(fileName);
        FileWriter fw = new FileWriter(fileName, false);

        ArrayList<String> myCollection = new ArrayList<>();

        String firstLine = sc.nextLine();
        myCollection.add(firstLine);



        try(FileWriter fw = new FileWriter(fileName, false)) {
            while(sc.hasNextLine()) {
                fw.write(sc.nextLine());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

}