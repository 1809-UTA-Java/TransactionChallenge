package com.revature;

class ListThread extends Thread {
	
	public void run() {
		try {
			System.out.println("Thread " + Thread.currentThread().getId() + " is reading");
		} catch (Exception e) {
			System.out.println("Exception hit");
		}
	}
}
public class TransactionChallenge {

	public static void main(String[] args) {
		// TODO 
		int iThreadCount = 2;
		for(int i = 0; i < iThreadCount; i++) {
			ListThread tThread = new ListThread();
			tThread.start();
		}
	}

}
