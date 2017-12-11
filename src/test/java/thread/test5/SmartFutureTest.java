package thread.test5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SmartFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SmartThreadExecutorPool smartThreadExecutorPool =
                new SmartThreadExecutorPool(5,10,10, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        //提交一个任务
        SmartFuture<String> smartFuture = smartThreadExecutorPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "当前时间：" + System.currentTimeMillis();
            }
        });

        smartFuture.addListener(new SmartFutureListener<String>() {
            @Override
            public void onSuccess(String result) {
                System.out.println("异步回调成功,"+result);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("异步回调失败,"+throwable);
            }
        });

        String syncResult = smartFuture.get();
        System.out.println("同步回调成功："+syncResult);
    }
}
