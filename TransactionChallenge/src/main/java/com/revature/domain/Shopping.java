package com.revature.domain;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Shopping implements Runnable{
	
	
	
	public void run() {
		System.out.println("hello");
	}
	
	public static void main(String[] args) {
		
		//Read user input file
		Scanner scan = new Scanner(System.in);
		System.out.println("Name your file ...");
		String fileName = scan.nextLine();
		
		try {
			FileReader fr = new FileReader(fileName);
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		
		//Create and run 2 threads
		Shopping cart = new Shopping();
		Thread thread1 = new Thread(cart);
		Thread thread2 = new Thread(cart);
		thread1.start();
		thread2.start();
		
		
	}
}
