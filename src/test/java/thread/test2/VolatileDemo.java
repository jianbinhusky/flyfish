package thread.test2;

public class VolatileDemo {
    volatile static Boolean flag=true;
    public static void main(String[] args) throws Exception {
        //该线程每隔1毫秒，修改一次flag的值
        while (flag) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        this.sleep(1000);
                        flag=!flag;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        //主线程通过死循环不断根据flag进行判断是否要执行某段代码
        while(true){
//            Thread.sleep(1000);
//            if(flag){
//                System.out.println("do some thing...");
//            }else {
//                System.out.println("...");
//            }
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (flag) {
                        System.out.println("do something...");
                    } else {
                        System.out.println("...");
                    }
                }
            }.start();
        }


    }
}
