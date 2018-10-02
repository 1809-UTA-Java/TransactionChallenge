package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class ShoppingCart extends Thread {
    static volatile File file = new File ("grocerystore.txt");
    private ArrayList<String> myCollection = new ArrayList<>();

    public ArrayList<String> getCollection () {
        return myCollection;
    }

    @Override
    public void run() {
        while (true) {
            try (Scanner sc = new Scanner(file)) {
                String firstLine = null;
                    if (sc.hasNextLine()) {
                        firstLine = sc.nextLine();
                    }
                    else {
                        break;
                    }
                    myCollection.add(firstLine);
                    file = ShoppingCart.writeToFile(file, sc);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    static private synchronized File writeToFile(File file, Scanner sc) {
        try(FileWriter fw = new FileWriter(file, false)) {
            while(sc.hasNextLine()) {
                fw.write(sc.nextLine()+"\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        //this.notify();
        return file;
    }

}