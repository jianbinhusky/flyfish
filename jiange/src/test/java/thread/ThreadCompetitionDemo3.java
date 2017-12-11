package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadCompetitionDemo3 {
    //    static int count = 0;
    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    count.addAndGet(1);
                }
                System.out.println("Defined Thread Count Completed Takes : " + (System.currentTimeMillis() - start));
            }
        }.start();

        for (int i = 0; i < 5000000; i++) {
            count.addAndGet(1);
        }
        System.out.println("Main Thread Count Completed Takes : " + (System.currentTimeMillis() - start));
        Thread.sleep(5000);
        System.out.println("Count = " + count);
    }
}
