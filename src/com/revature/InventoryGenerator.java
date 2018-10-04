package com.revature;

import java.io.*;
import java.util.*;

/**
 * InventoryGenerator auto generates list of 
 * "inventory items" into "inventory.txt" file 
 * in the "junk" folder for the pupose of testing 
 * TransactionChallenge program
 * 
 * To run it, type - java -cp bin com.revature.InventoryGererator
 * 
 * @author Leonardo De Leon
 */
public class InventoryGenerator {

    public static void main(String[] args) {
        InventoryGenerator ig = new InventoryGenerator();
        ig.generateInventory();    
    }

    public void generateInventory () {
        String fileName = "inventory";
        File inputFile = new File("junk/"+(fileName+=".txt"));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile));
            for (int i = 0; i < 10; i++) {
                bw.write("abc"+i + System.getProperty("line.separator"));
            }
            bw.close();

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}


