package com.revature.fileManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TransactionReader implements FileReadable {

	@Override
	public String readFile(String fileName) {
		String out;
		
		try(FileReader fr = new FileReader(fileName)) {
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	


}
