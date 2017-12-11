package thread.test6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {
    volatile static int index;
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        int N = 5;
        CyclicBarrier barrier  = new CyclicBarrier(N);
        for(int i=0;i<N;i++) {
            new Writer(barrier).start();
        }
        index = barrier.await();
        System.out.println("主线程执行" +index);
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(2000);      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                index = cyclicBarrier.await();
//                System.out.println(index);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch(BrokenBarrierException e){
                e.printStackTrace();
            }
//            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }
}
