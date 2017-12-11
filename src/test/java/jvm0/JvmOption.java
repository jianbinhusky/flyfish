package jvm0;

/**
 * Created by hujb4 on 2016/8/29.
 */
public class JvmOption {

    public static void main(String[] args) {
        System.out.println("-Xmx = " + Runtime.getRuntime().maxMemory() / 1000 / 1000 + " M  ");
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() / 1000 / 1000 + " M ");
        System.out.println("toatlMemory = " + Runtime.getRuntime().totalMemory() / 1000 / 1000 + " M ");

        byte[] bytes = new byte[1 * 1024 * 1024];
        System.out.println("alloc 1M space to array...");

        System.out.println("-Xmx = " + Runtime.getRuntime().maxMemory() / 1000 / 1000 + " M  ");
        System.out.println("freeMemory = " + Runtime.getRuntime().freeMemory() / 1000 / 1000 + " M ");
        System.out.println("toatlMemory = " + Runtime.getRuntime().totalMemory() / 1000 / 1000 + " M ");
    }
}
