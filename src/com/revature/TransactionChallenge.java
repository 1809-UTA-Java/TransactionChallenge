package com.revature;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Using Files, I/O, Collections, and Threads, create a program that will 
 * read a text file containing an inventory list of items. It should then 
 * create two or more threads, each one using a separate Collection object 
 * to take and store items from the list, then save the changes to the initial 
 * file, before allowing another thread its turn to take items. Then print 
 * the items of each thread. The total number should equal the initial number 
 * in the original file.
 * 
 * 1 - read shoppingcart.txt
 * 2 - create 2 threads associated w separate Collection object 
 * 3 - 
 * 
 * make a constructor creating one thread and one collection object 
 * 
 * @param args
 */

 public class TransactionChallenge extends Thread {
		
	/* THREAD RUN() */
	public void run() {
		String st; 
		BufferedReader br = null;
		ArrayList<String> shopList = new ArrayList<String>();
		

		try {
			br = new BufferedReader(new FileReader("shoppingcart.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		try {
			while ((st = br.readLine()) != null) {
				shopList.add(st);
				// TODO: then remove that item from the txt file 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(shopList);
		
	}
	

	
	/* DRIVER */
	public static void main(String args[]) {
		
		TransactionChallenge t1 = new TransactionChallenge();
		TransactionChallenge t2 = new TransactionChallenge();

		t1.start();
		t2.start();
		
	}
	
	
	

	
	
}

