package thread.test6;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorTest {

    public static void main(String[] args) {
        System.out.println("Start Time : " + new Date());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hu Yike : " + new Date());
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 3, 1, TimeUnit.SECONDS);
//        service.scheduleWithFixedDelay(runnable, 3, 1, TimeUnit.SECONDS);
    }
}
