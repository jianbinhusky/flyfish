package thread.test6;

import java.util.concurrent.CountDownLatch;

public class TestVolatileAgain {

    private  static volatile  int value = 0;

    private static int temp;

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(2);

        new Thread("A"){

            @Override
            public void run() {
                value = 9;
                latch.countDown();
                System.out.println(Thread.currentThread().getName());
            }

        }.start();

        new Thread ("B"){
            @Override
            public void run() {
                temp = value + 9;
                latch.countDown();
                System.out.println(Thread.currentThread().getName());
            }
        }.start();

        try {
            latch.await();
            System.out.println(Thread.currentThread().getName());
            System.out.println(value);
            System.out.println(temp);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
