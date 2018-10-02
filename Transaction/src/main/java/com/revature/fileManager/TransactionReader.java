package com.revature.fileManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionReader implements FileReadable {

	@Override
	public String readFile(String fileName) {
		String readLine1 = "", readLine2 = "";
		List<String> list = new ArrayList<>();
	
		try {
			BufferedReader br1 = new BufferedReader(new FileReader(fileName));
			BufferedReader br2 = new BufferedReader(new FileReader(fileName));
			
			if ((readLine1 = br1.readLine()) != null) {
				
				readLine2 = br2.readLine();
				
				while(readLine2 != null) {
					list.add(readLine2);
					readLine2 = br2.readLine();
				}
				
				// close reading resources
				br1.close();
				br2.close();
				
				// open writing resource (CAN'T read & write due to blocking)
				FileWriter fw = new FileWriter(fileName);
				
				for(String l : list) {
					// ONLY pass file lines not read
					if (!readLine1.contentEquals(l)) {
						fw.append(l + "\n");
					}
				}
		
				// close resources
				fw.flush();
				fw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return readLine1;
	}	
}
