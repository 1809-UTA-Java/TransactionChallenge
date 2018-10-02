package com.revature.Transaction;

public class Multithread 
{
    public static void main( String[] args )
    {
    	String file = "/home/developer/Workspace/TransactionChallenge/Groceries.txt";
    	
    	TransactionReader fm = new TransactionReader();
    	
    	System.out.println(fm.readFile(file));
    }
}