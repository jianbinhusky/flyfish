package thread.test3;

import java.util.Date;

public class MutexMain {
    public static void main(String[] args) {
        Mutex mutex = new MutexImpl();
        for (int i = 0; i < 5; i++) {
            new MutexThread("Thread-" + i, mutex).start();
        }
    }

    static class MutexThread extends Thread {
        private Mutex mutex;

        public MutexThread(String name , Mutex mutex) {
            this.mutex = mutex;
            this.setName(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start...");
            mutex.lock();
            System.out.println(Thread.currentThread().getName() + " Acquire Lock Successful.");
            System.out.println(Thread.currentThread().getName() + " Start execute , current time : " + new Date().toLocaleString());
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " Complete execute , current time : " + new Date().toLocaleString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " Release Lock...");
                mutex.release();
            }
        }

    }

}
