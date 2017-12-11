package thread;

public class JoinDemo2 {

    final  Thread d = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                t.join();
                System.out.println(Thread.currentThread().getName() + " Run...");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " Complete.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    },"Mengo");

    final Thread t = new Thread("Nemo"){
        @Override
        public void run(){
            try {
                d.join();
                System.out.println(Thread.currentThread().getName() + " Run...");
                Thread.sleep(4000);
                System.out.println(Thread.currentThread().getName() + " Complete.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("Main Start...");

//        final Thread d = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//
//                    System.out.println(Thread.currentThread().getName() + " Run...");
//                    Thread.sleep(5000);
//                    System.out.println(Thread.currentThread().getName() + " Complete.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"Mengo");
//        d.start();
//
//        final Thread t = new Thread("Nemo"){
//            @Override
//            public void run(){
//                try {
//                    d.join();
//                    System.out.println(Thread.currentThread().getName() + " Run...");
//                    Thread.sleep(4000);
//                    System.out.println(Thread.currentThread().getName() + " Complete.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        t.start();

        JoinDemo2 joinDemo2 = new JoinDemo2();
        joinDemo2.d.start();
        joinDemo2.t.start();

        Thread.sleep(2000);
        System.out.println("Main Complete waiting others...");
        long joinstart = System.currentTimeMillis();
//        t.join();
        System.out.println("Have waited " + (System.currentTimeMillis() - joinstart) / 1000 + " s");
        System.out.println("Demo total run " + (System.currentTimeMillis() - start) / 1000 + " s");
    }
}

class Tigger implements Runnable{

    @Override
    public void run() {

    }
}