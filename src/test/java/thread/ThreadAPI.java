package thread;

import java.util.Date;

public class ThreadAPI {
    public static void main(String[] args) throws InterruptedException {
        Monkey m = new Monkey();
        Thread t = new Thread(m, "monkey");
        t.start();

        Thread.sleep(3000);
        t.interrupt();
    }
}

class Monkey implements Runnable{

    public void eat(){

    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("Current datetime is : " + new Date().toLocaleString());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Interrupt here");
            }
        }
    }
}
