package thread.test5;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.FutureTask;

public class SmartFuture<V> extends FutureTask<V> {
    //异步通知的listener
    private Set<SmartFutureListener> listeners=null;

    //任务运行结果
    Object result=null;
    private boolean hasResult;
    public SmartFuture(Callable<V> callable) {
        super(callable);
        listeners=new CopyOnWriteArraySet<SmartFutureListener>();
    }

    public SmartFuture(Runnable runnable, V result) {
        super(runnable, result);
        listeners=new CopyOnWriteArraySet<SmartFutureListener>();
    }

    public void addListener(SmartFutureListener listener){
        if(listener==null){
            throw new NullPointerException();
        }
        if(hasResult){//如果添加listener的时候，任务已经执行完成，直接回调listener
            notifyListener(listener);
        }else{//如果任务没有执行完成，添加到监听队列
            listeners.add(listener);
        }
    }

    //覆写set方法，结果运行成功
    @Override
    protected void set(V v) {
        super.set(v);
        result=v;
        hasResult=true;
        notifyListeners();
    }
    //覆写 setException方法
    @Override
    protected void setException(Throwable t) {
        super.setException(t);
        result=t;
        hasResult=true;
        notifyListeners();
    }

    //回调
    private void notifyListeners() {
        for (SmartFutureListener listener : listeners) {
            notifyListener(listener);
        }
    }

    private void notifyListener(SmartFutureListener listener) {
        if(result instanceof Throwable){
            listener.onError((Throwable) result);
        }else{
            listener.onSuccess(result);
        }
        listeners=null;
    }
}
