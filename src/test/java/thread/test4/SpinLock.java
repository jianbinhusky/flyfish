package thread.test4;

import java.util.Date;

public class SpinLock {

    public static String sharedVariable;

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    sharedVariable = "Thread";
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        System.out.println("Start Time : " + new Date());

        while (sharedVariable == null) {

        }

        System.out.println(sharedVariable);

        System.out.println("End Time : " + new Date());
    }
}
