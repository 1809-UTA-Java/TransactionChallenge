package com.revature.Transaction;

import com.revature.fileManager.*;

public class App 
{
    public static void main( String[] args )
    {
    	String file = "Groceries.txt";
    	
    	TransactionReader fm = new TransactionReader();
    	
    	System.out.println(fm.readFile(file));
    }
}
