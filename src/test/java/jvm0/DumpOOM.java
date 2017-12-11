package jvm0;

import java.util.Vector;

/**
 * Created by hujb4 on 2016/8/29.
 */
public class DumpOOM {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1 * 1024 * 1024]);
        }
    }
}
