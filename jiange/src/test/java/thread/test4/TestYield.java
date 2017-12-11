package thread.test4;

public class TestYield {

    public static void main(String[] args) throws InterruptedException {
        final Thread a = new Thread("A") {
            @Override
            public void run(){
                System.out.println("I'm Apple. --> " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("elppA : " +e.getLocalizedMessage());
                    e.printStackTrace();
                }
//                Thread.yield();
            }
        };

        final Thread b = new Thread("B") {
            @Override
            public void run(){
                try {
                    a.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I'm Banana.--> " + Thread.currentThread().getName());
            }
        };

        a.start();
        b.start();

        a.join();
        b.join();

        a.interrupt();
        b.interrupt();
    }
}
