package thread.test5;

import java.util.concurrent.*;

public class SmartThreadExecutorPool extends ThreadPoolExecutor {
    public SmartThreadExecutorPool(int corePoolSize, int maximumPoolSize,
                                   long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new SmartFuture<T>(runnable,value);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new SmartFuture<T>(callable);
    }

    //覆写这三个方法只是为了用户在使用的时候，方便一点，不需要将Future强转为SmartFuture
    @Override
    public SmartFuture<?> submit(Runnable task) {
        return (SmartFuture<?>) super.submit(task);
    }
    @Override
    public <T> SmartFuture<T> submit(Runnable task, T result) {
        return (SmartFuture<T>) super.submit(task, result);
    }
    @Override
    public <T> SmartFuture<T> submit(Callable<T> task) {
        return (SmartFuture<T>) super.submit(task);
    }
}
