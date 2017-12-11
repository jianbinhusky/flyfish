package thread.test3;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MutexImpl implements Mutex {

    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void release() {
        sync.release(1);
    }

    private static class Sync extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            return compareAndSetState(1, 0);
        }
    }
}
