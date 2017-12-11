package thread.test3;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();
        new Thread("Thread A") {
            @Override
            public void run(){
                lock.lock();
                try {
                    work();
                } finally {
                    lock.unlock();
                }
            }
        }.start();

        new Thread("Thread B") {
            @Override
            public void run(){
                lock2.lock();
                try {
                    work();
                } finally {
                    lock2.unlock();
                }
            }
        }.start();
    }

    public static void work(){
        try {
            System.out.println(Thread.currentThread().getName() + " - Started to work, current time : " + new Date().toLocaleString());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " - End work, current time : " + new Date().toLocaleString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
