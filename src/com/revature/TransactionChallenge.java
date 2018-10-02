package com.revature;

import java.io.*;
import java.util.*;

/**
 * TransactionChallenge is an app that reads from a file 'sample-item'
 * that contains list of items (apple, bread, eggs, etc) and extract the
 * items using two separate threads and putting them into their own
 * container
 * 
 * @author Leonardo De Leon 
 */
public class TransactionChallenge {
    public static void main(String[] args) {
        String fileName = "sample-items";
        ArrayList<String> listOfItems = new ArrayList<>();

        // try open and read file
        try {
            // open the journal and read the contents
            System.out.println("Reading files...");
            listOfItems = openAndReadFilesContent(fileName);   
            
            for (int x=0; x<listOfItems.size(); x++)
                System.out.println(listOfItems.get(x));
        } catch (IOException io) {
            io.printStackTrace();
        }

        
        
        
    }

	static ArrayList<String> openAndReadFilesContent (String fileName) throws IOException {
		ArrayList <String> contents = new ArrayList<>();
		String line;
		BufferedReader br = new BufferedReader(new FileReader("junk/"+(fileName+=".txt")));
		while ((line = br.readLine()) != null) {;
			contents.add(line);
		}
		br.close();		
		return contents;
	}    
}