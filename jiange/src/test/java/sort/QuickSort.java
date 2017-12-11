package sort;

/**
 * Created by hujb4 on 2017/2/13.
 */
public class QuickSort {
    static int[] array = {6,3,8,7,4,2,1,5,9};

    static {
        System.out.println("Static module");
    }

    public void quickSort(int left, int right) {
        if(left > right){
            return;
        }
        int i = left, j = right, temp = array[left];
        while (i != j) {
            while (temp >= array[i] && i < j) {
                i++;
            }
            while (temp <= array[j] && i < j) {
                j--;
            }
            if (i < j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                printArray();
            }
        }
        array[left] = array[i];
        array[i] = temp;
        printArray();
        quickSort(left, i - 1);
        quickSort(i + 1, right);

    }

    public void printArray(){
        System.out.println();
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(0,array.length-1);

        quickSort.printArray();

        System.out.println();
        ClassLoader loader = QuickSort.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }

    }
}
