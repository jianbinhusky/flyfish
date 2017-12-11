package thread;

public class SynchronizedTest2 {

    public static void main(String[] args) {
        Tank xMBank = new Tank();
        Tank xGBank = new Tank();
        Tank xHBank = new Tank();

        Thread xMThread = new Thread(xMBank, "小明");
        Thread xGThread = new Thread(xGBank, "小刚");
        Thread xHThread = new Thread(xHBank, "小红");
//        xMThread.start();
//        xGThread.start();
//        xHThread.start();
        final Tank tank = new Tank();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                new Tank().deposit(200);
//                new Tank().print();
                tank.deposit(200);

            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                new Tank().deposit(200);
//                new Tank().print();
                tank.print();
            }
        },"t2");
//        t2.start();

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                new Tank().deposit(200);
//                new Tank().print();
                tank.print();
            }
        },"t3");
//        t3.start();

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                new Tank().deposit(200);
//                new Tank().print();
                tank.print();

            }
        },"t4");
//        t4.start();
        tank.print();
    }
}

class Tank extends Thread {

    private static int money = 1000;

    public  Tank(){

    }

    public static synchronized void print(){
        System.out.println("#" +Thread.currentThread().getName() + "----> Non Synchronized method");
        try {
            System.out.println("waiting ...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void deposit(int money) {
//         synchronized (this) { // 同步方法块（实例对象）
//         synchronized (Tank.class) { // 同步方法块（实例对象）
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "--当前银行余额为：" + Tank.money);
        Tank.money += money;
        System.out.println(threadName + "--存入后银行余额为：" + Tank.money);
        try {
            System.out.println("waiting ...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//         }
    }

    public void run(){
        deposit(200);
    }
}
