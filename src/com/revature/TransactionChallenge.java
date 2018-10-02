package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionChallenge {

	public static void main(String[] args) throws FileNotFoundException {
		Thread t1 = new Thread(new MyThread ());
		Thread t2 = new Thread(new MyThread ());
		t1.start();
		t2.start();
		
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new File("/home/developer/eclipse-workspace/demo/list"));
		ArrayList<String> list = new ArrayList<String>();
		while (s.hasNext()){
		    list.add(s.next());
		}
		
		System.out.println(list);
		s.close();
		
	}

}