package com.revature;

import java.io.*;
import java.util.*;
import java.lang.Runnable;

/**
 * TransactionChallenge is an app that reads from a file 'inventory.txt'
 * that contains list of items (apple, bread, eggs, etc) and extract the
 * items using two separate threads and putting them into their own
 * container
 * 
 * To run it, type java -cp bin com.revature.TransactionChallenge at the terminal
 * 
 * @author Leonardo De Leon 
 */
public class TransactionChallenge implements Runnable {

    ArrayList<String> inventory; 

    public TransactionChallenge(ArrayList<String> inventory) {
        this.inventory = inventory;
    }   
    
    public static void main(String[] args) {

        String fileName = "inventory";
        ArrayList<String> al = new ArrayList<>();
        try {
            al = TransactionChallenge.openReadAndWriteFilesContent(fileName);
        } catch (IOException io) {
            io.getMessage();
        }
        
        TransactionChallenge tc = new TransactionChallenge(al);

        // create the threads, t1 and t2, and passing obj tc
        Thread t1 = new Thread(tc, "Thread 1");  
        Thread t2 = new Thread(tc, "Thread 2"); 

        // start the threads
        t1.start(); System.out.println(t1.getName());
        t2.start(); System.out.println(t2.getName());
    }

    @Override
    public void run() {
        ArrayList<String> arrs = new ArrayList<>();

        // threads loops thru inventory, grab an item 
        // and when they are done, remove items
        for (int i = 0; i < inventory.size(); i++) {
            arrs.add(inventory.get(i));
            inventory.remove(i);
        }
        // show what's in threads 1 and threads 2
        System.out.println(arrs);        
    }

	public static ArrayList<String> openReadAndWriteFilesContent(String fileName) throws IOException {
        ArrayList <String> contents = new ArrayList<>();

        File inputFile = new File("junk/"+(fileName+=".txt"));
        File tempFile = new File("junk/my"+(fileName+=".txt"));

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            contents.add(currentLine);
            writer.write("");
        }
        writer.close(); // close writer
        reader.close(); // close reader

        // rename file
        tempFile.renameTo(inputFile);
        return contents;
    }       
}