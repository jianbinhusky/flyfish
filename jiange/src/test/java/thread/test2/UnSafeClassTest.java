package thread.test2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeClassTest {

    private int i = 0;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        long offset = unsafe.objectFieldOffset(UnSafeClassTest.class.getDeclaredField("i"));
        UnSafeClassTest unSafeClassTest = new UnSafeClassTest();
        unsafe.putInt(unSafeClassTest, offset, 100);
        System.out.println(unSafeClassTest.i);
    }
}
