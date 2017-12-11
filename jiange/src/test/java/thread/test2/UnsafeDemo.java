package thread.test2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {
    public static void main(String[] args) throws Exception{
        Field f = Unsafe.class.getDeclaredField("theUnsafe"); // Internal reference
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        // This creates an instance of player class without any initialization
        Player p = (Player) unsafe.allocateInstance(Player.class);
        System.out.println(p.getAge()); // Print 0

        p.setAge(45); // Let's now set age 45 to un-initialized object
        System.out.println(p.getAge()); // Print 45
    }
}

class Player {
    private int age = 12;

    public Player() {
        this.age = 50;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
