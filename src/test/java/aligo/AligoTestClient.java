package aligo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by hujb4 on 2016/5/25.
 */
public class AligoTestClient {
    //handle array
    private int row = 4;
    private int column = 4;
    private int array[][] = new int[row][column];
    private int seed = 3;

    //handle string
    String value = "We are happy what a fucking river oh my god";
    String newValue = "We%20are%20happy";
    private char[] str = value.toCharArray();
    private char[] var;

    //handle two sort array
    private Integer[] sort1 = new Integer[6];
    private Integer[] sort2 = new Integer[20];

    @Before
    public void beforeTest(){
        System.out.println("Test Start now...");
        System.out.println("#######################################");
        array[0][0] = 1;array[0][1] = 2;array[0][2] = 8;array[0][3] = 9;
        array[1][0] = 2;array[1][1] = 4;array[1][2] = 9;array[1][3] = 12;
        array[2][0] = 4;array[2][1] = 7;array[2][2] = 10;array[2][3] = 13;
        array[3][0] = 6;array[3][1] = 8;array[3][2] = 11;array[3][3] = 15;

        for (int i = 0; i < sort1.length; i++) {
            sort1[i] = i*2 + 3;
            sort2[i] = i*2 + 2;
        }
    }

    @After
    public void afterTest(){
        System.out.println("#######################################");
        System.out.println("Test Done.");
    }

    @Test
    public void handleArray(){
        System.out.println("Init Array as follow:");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        boolean flag = false;
        int rowVar = 0;
        int columnVar = column -1;
        int count = 0;
        while (rowVar < row && columnVar >= 0){
            ++count;
            if(array[rowVar][columnVar] == seed){
                flag = true;
                break;
            }else if(array[rowVar][columnVar] < seed){
                ++rowVar;
            }else {
                --columnVar;
            }
        }
        System.out.println("execute while loop " + count + " times");
        System.out.println("The number " + seed + " is in array is " + flag);
    }

    @Test
    public void handleString(){
        int originLength = 0;
        int numberOfBlank = 0;
        for (char c : str) {
            Character cc = c;
            if(cc.isWhitespace(c)){
                ++numberOfBlank;
            }else {
                ++originLength;
            }
        }
        System.out.println("originLength = " +originLength + ", numberOfBlank = "+numberOfBlank);

        int newLength = originLength + numberOfBlank * 3;
        var = new char[newLength];
        for (int i = 0; i < str.length; i++) {
            var[i] = str[i];
        }
        int originIndex = str.length-1;
        int newIndex = newLength -1;
        while (originIndex >= 0 && newIndex > originIndex) {
            Character ca = str[originIndex];
            if(ca.isWhitespace(ca) && originIndex > 0) {
                var[newIndex--] = '0';
                var[newIndex--] = '2';
                var[newIndex--] = '%';
            }else {
                var[newIndex--] = var[originIndex];
            }
            --originIndex;
        }
        StringBuffer sb = new StringBuffer();
        for (char c : var) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void handleTwoSortArray(){
        for (int i = 0; i < sort1.length; i++) {
            System.out.print(sort1[i] + "\t");
        }
        System.out.println();
        int sort2Count = 0;
        for (int i = 0; i < sort2.length; i++) {
            if(sort2[i] != null){
                ++sort2Count;
            }
            System.out.print(sort2[i] + "\t");
        }
        System.out.println();

        int shortLength = sort1.length;
        int shortIndex = shortLength -1;
        int longIndex = sort2Count -1;
        int mergeLength = shortLength + sort2Count;
        int mergeIndex = mergeLength -1;
        int temp = sort1[shortIndex];
        while (shortIndex >= 0 && longIndex >=0 && mergeIndex >= 0) {
            if(sort1[shortIndex] > sort2[longIndex]){
                sort2[mergeIndex--] = sort1[shortIndex--];
            }else {
                sort2[mergeIndex--] = sort2[longIndex--];
            }
        }
        for (int i = 0; i < sort2.length; i++) {
            if(sort2[i] != null){
                ++sort2Count;
            }
            System.out.print(sort2[i] + "\t");
        }
        System.out.println();
    }

    @Test
    public void handleIndexQ(){
        String quote = "\"";

        String s1 = "\" What a perfect! \"";
        String s2 = " What a \" perfect!\" ";
        System.out.println(s2);
        System.out.println(s1.indexOf(quote));
        System.out.println(s2.indexOf(quote));

//        if(s2.indexOf(quote) == -1){
//            s2 = quote + s2 + quote;
//            System.out.println(s2);
//        }

//        System.out.println(s2.startsWith(quote));
//        System.out.println(s2.endsWith(quote));

        if(!(s2.trim().startsWith(quote) && s2.trim().endsWith(quote))){
            s2 = quote + s2 + quote;
            System.out.println(s2);
        }

        if(s1.startsWith(quote) && s1.endsWith(quote)){
//            System.out.println(true);
        }

    }
}
