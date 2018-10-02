package com.revature;

import java.util.*;
import java.io.*;

public class FileConsumer implements Runnable {
    private ArrayList<String> list;
    public FileConsumer(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        File tempFile = new File("tempFile.txt");

        String line;    
        ArrayList<String> threadList = new ArrayList<>();

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(tempFile));
            while (list.size() != 0) {
                line = list.get(0);

                list.remove(0);
                writer.write(line + "\n");
                threadList.add(line);

                Thread.sleep(5);
            }
            writer.close();
        } 
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        } 

        System.out.println("\n" + Thread.currentThread());
        for (int i = 0; i < threadList.size(); i++) {
            System.out.print(threadList.get(i) + " ");
        }
        System.out.println();
    }
}