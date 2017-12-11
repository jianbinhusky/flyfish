package thread;

public class SynchronizedTest1 {

    public static void main(String[] args) {
        Bank xMBank = new Bank();
        Bank xGBank = new Bank();
        Bank xHBank = new Bank();

        Thread xMThread = new Thread(xMBank, "小明");
        Thread xGThread = new Thread(xGBank, "小刚");
        Thread xHThread = new Thread(xHBank, "小红");
        xMThread.start();
        xGThread.start();
        xHThread.start();
    }
}

class Bank extends Thread {

    private int money = 1000;

    public synchronized void deposit(int money) {
        // synchronized (this) { // 同步方法块（实例对象）
        // synchronized (bank) { // 同步方法块（实例对象）
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "--当前银行余额为：" + this.money);
        this.money += money;
        System.out.println(threadName + "--存入后银行余额为：" + this.money);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // }
    }

    public void run(){
        deposit(200);
    }
}
