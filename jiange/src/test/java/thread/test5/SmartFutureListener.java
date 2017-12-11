package thread.test5;

public interface SmartFutureListener<V> {
    void onSuccess(V result);

    void onError(Throwable throwable);
}
