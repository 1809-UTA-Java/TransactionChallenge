import java.io.*;
import java.util.*;


class transaction implements Runnable {
    public static void main(String[] args) {
        System.out.println("Inside : " + Thread.currentThread().getName());



        System.out.println("Creating Runnable...");
        Runnable runnable = new transaction();

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        System.out.println("Starting Threads...");
        thread.start();
        thread2.start();

    }

    @Override
    public void run() {
        System.out.println("Inside : " + Thread.currentThread().getName());
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayWrite = new ArrayList<String>();
        String fileName = "example.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            //System.out.println(br.readLine());
            if((line = br.readLine()) != null) {
                arrayList.add(line);
                //System.out.println(line);
            }
            while ((line = br.readLine()) != null) {
                arrayWrite.add(line);
                //System.out.println(line);
            }
        }  catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("File not found\n");
        }  catch (IOException ex) {
            ex.printStackTrace();
        }

        try(FileWriter fw = new FileWriter(fileName)) {
            for(String thing : arrayWrite)
                fw.write(thing);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(arrayList);
    }
}