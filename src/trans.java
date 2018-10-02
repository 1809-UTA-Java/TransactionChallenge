//

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
        ArrayList<String> arrayList = new ArrayList<>();
        String fileName = "example.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                arrayList.add(line);
                line.trim();
            }
        }
    }
}