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

    String fileName = "inventory";

    public static void main(String[] args) {
 
        TransactionChallenge tc = new TransactionChallenge();
        Thread t1 = new Thread(tc, "Thread 1");  
        Thread t2 = new Thread(tc, "Thread 2"); 
        t1.start(); System.out.println(t1.getName());
        t2.start(); System.out.println(t2.getName());
    }

	static synchronized void openReadAndWriteFilesContent (String fileName) throws IOException {
        ArrayList <String> contents = new ArrayList<>();
        File inputFile = new File("junk/"+(fileName+=".txt"));
        File tempFile = new File("junk/my"+(fileName+=".txt"));
		String line;
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
        while ((line = br.readLine()) != null) {;
            try {            
                contents.add(line);  
                bw.write("");   
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
        br.close();
        bw.close();	
        // show what's in threads 1 and threads 2
        System.out.println(contents);
        tempFile.renameTo(inputFile);
    }

    @Override
    public void run() {
        // try open and read from inventory list
        try {
            openReadAndWriteFilesContent(fileName);   
        } catch (IOException io) {
            io.printStackTrace();
        }
    }       
}