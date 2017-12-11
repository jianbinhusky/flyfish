package sort;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by hujb4 on 2017/2/8.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {45,34,12,76,5,33,89};

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if(nums[j] < nums[j+1]){
                    int temp = nums[j+1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        for (int num : nums) {
            System.out.print(num + "\t");
        }

//        short a = 128;
        int a = 128;
        byte b = (byte) a;
        System.out.println(a);
        System.out.println(b);

        final String s1 = "abc";
        System.out.println(s1);

        Map<String, String> map = new LinkedHashMap<String, String>();
//        Map<String, String> map = new TreeMap<String, String>();
//        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "f");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println(stringStringEntry.getKey() + "\t" + stringStringEntry.getValue());
        }

        int h = 5;
        int temp;

//        h ^= (h >>> 20) ^ (h >>> 12);
//        temp = h ^ (h >>> 7) ^ (h >>> 4);

//        h = h ^ (h >>> 20) ^ (h >>> 12);
//        temp = h ^ (h >>> 7) ^ (h >>> 4);

        System.out.println(h>>>20);
        System.out.println(h>>>12);

        System.out.println(5>>>20);
        System.out.println(5>>>12);

        temp = h;

        System.out.println(temp);
        System.out.println(Integer.toBinaryString(15));
        System.out.println(Integer.toBinaryString(20));
        System.out.println(5>>>2);
        System.out.println(Integer.toBinaryString(0));

    }
}
