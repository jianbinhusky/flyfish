package thread.test4;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFuture {
    public static void main(String[] args) {
        System.out.println("Start Time : " + new Date());
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<String> future = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Thread";
            }
        });

        try {
            String result = future.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("End Time : " + new Date());
        pool.shutdown();
    }
}
