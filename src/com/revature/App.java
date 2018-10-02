package com.revature;

import java.util.*;
import java.io.*;

public class App {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();

        // write items to file
        // try (PrintWriter writer = new PrintWriter("items.txt")) {
        //     for (int i = 0; i < 1000; i++) {
        //         writer.println(i);
        //     }
        //     writer.close();
        // } catch (FileNotFoundException ex) {
        //     ex.printStackTrace();
        // }

        /* add every item to ArrayList */
        try (BufferedReader br = new BufferedReader(new FileReader("items.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }  catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // System.out.println(Thread.currentThread());
        // for (int i = 0; i < list.size(); i++) {
        //     System.out.print(list.get(i) + " ");
        // }

        FileConsumer fileIO = new FileConsumer(list);
        Thread thread1 = new Thread(fileIO);
        Thread thread2 = new Thread(fileIO);

        thread1.start();
        thread2.start();
    }
}