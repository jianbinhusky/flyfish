package attack;

/**
 * Created by hujb4 on 2016/7/21.
 */
public class TestThreadLocal {

    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue(){
            return Integer.valueOf(0);
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(i)).start();
        }
        System.getProperty("");
    }

    static class MyThread implements Runnable{

        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println("Thread " + index +  " initialValue is " + value.get());
            for (int i = 0; i < 10; i++) {
                value.set(value.get() + i);
            }
            System.out.println("Thread " + index + " toatalValue is " + value.get());
        }
    }
}
