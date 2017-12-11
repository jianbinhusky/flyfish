package thread;

public class ThreadCompetitionDemo2 {
    volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        final long start = System.currentTimeMillis();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000000; i++) {
                    count++;
                }
                System.out.println("Defined Thread Count Completed Takes : " + (System.currentTimeMillis() - start));
            }
        }.start();

        for (int i = 0; i < 5000000; i++) {
            count++;
        }
        System.out.println("Main Thread Count Completed Takes : " + (System.currentTimeMillis() - start));
        Thread.sleep(5000);
        System.out.println("Count = " + count);
    }
}
