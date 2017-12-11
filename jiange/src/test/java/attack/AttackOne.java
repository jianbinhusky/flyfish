package attack;

/**
 * Created by hujb4 on 2016/7/20.
 */
public class AttackOne {


    public static void main(String[] args) {
        for (int i = 0; i < 2000; i++) {
            AttackTask at = new AttackTask();
            Thread t = new Thread(at);
            System.out.println(t.getName() + " start ...");
            t.start();
        }
    }
}
