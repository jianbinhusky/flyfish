package struct.sort;

import java.util.Random;
import java.util.Stack;

public class Sort {
	private final static int N = 5;
	
	public static void display(int[] args){
		String str = "";
		for (int i : args) {
			str += i + "," ;
		}
		str = str.substring(0,str.length()-1);
		System.out.println(str);
	}
	
	/**
	 * 冒泡排序
	 * 
	 * 相邻两两比较，大的放后面
	 * 	外层循环须len-1次
	 * 	 内层循环须len-1-i次
	 * 	  内循环比出大者至于后
	 * @param args
	 */
	public static void bubbleSort(int[] args){
		for (int i = 0; i < args.length - 1; i++) {
			for (int j = 0; j < args.length - i - 1; j++) {
				if(args[j] > args[j+1]){
					int max = args[j];
					args[j] = args[j+1];
					args[j+1] = max;
				}
			}
		}
	}
	
	/**
	 * 选择排序
	 * 
	 * 每次选择出最小的置于最前面
	 *  外层循环len-1次，每次假设当前数最小存于min并记录当前下标
	 *   内层循环len-1-i次，采用循环量递减，每次从最后面的数字比起
	 *    将每次比得的小值存于min并记录此时下标
	 *     每次内层循环结束后将最终最小值与当前外层循环值交换
	 * 
	 * @param args
	 */
	public static void selectSort(int[] args){
		for (int i = 0; i < args.length - 1; i++) {
			int min = args[i];
			int index = i;
			for (int j = args.length - 1; j > i; j--) {
				if(min > args[j]){
					min = args[j];
					index = j;
				}
			}
			args[index] = args[i];
			args[i] = min;
		}
	}

	/**
	 * 插入排序
	 * 
	 * 从第二个数（依次到最后一个数）开始往前两两比较，小者交换插入到前面
	 * 	外层循环len-1次，为了下标方便从1起始
	 * 	 内层循环i次，起始从i起递减1
	 * 	  内层循环从第i数开始往前两两比较，小者插入到前面
	 * 		有点像冒泡反方向
	 * 
	 * @param args
	 */
	public static void insertSort(int[] args){
		for (int i = 1; i < args.length; i++) {
			for (int j = i ; j > 0; j--) {
				if( args[j] <  args[j-1]){
					int min = args[j];
					args[j] = args[j-1];
					args[j-1] = min;
				}
			}
		}
		
	}
	
	/**
	 * 归并排序合并算法
	 * @param args
	 * @param low
	 * @param mid
	 * @param high
	 */
	public static void merge(int[] args , int low , int mid , int high){
		int i = low;// i是第一段序列的下标
		int j = mid + 1;// j是第二段序列的下标
		int k = 0;// k是临时存放合并序列的下标
		int[] temp = new int[high - low + 1];// 临时合并序列
		
		 // 扫描第一段和第二段序列，直到有一个扫描结束
		while(i <= mid && j <= high ){
			if(args[i] <= args[j]){// 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
				temp[k++] = args[i++];
			}else{
				temp[k++] = args[j++];
			}
		}
		
		// 若第一段序列还没扫描完，将其全部复制到合并序列
		while(i <= mid){
			temp[k++] = args[i++];
		}
		// 若第二段序列还没扫描完，将其全部复制到合并序列
		while(j <= high){
			temp[k++] = args[j++];
		}
		
		// 若第二段序列还没扫描完，将其全部复制到合并序列
		for (int l = 0; l < temp.length; l++) {
			args[l + low] = temp[l];
		}
	}
	
	/**
	 * 没明白
	 * @param args
	 * @param subLen
	 * @param length
	 */
	@Deprecated
	public static void mergeDivide(int[] args , int subLen , int length){
		int i = 0;
		for (i = 0; i + subLen * 2 - 1 < length; i = i + subLen * 2) {
			merge(args, i, i + subLen -1, length -1);
		}
		
		if(i + subLen -1 < length){
			merge(args, i, i + subLen -1, length - 1 );
		}
	}
	
	/**
	 * 归并非递归--有误
	 * @param args
	 * //TODO
	 */
	@Deprecated
	public static void mergeSortNonRecursive(int[] args){
		for (int subLen = 1; subLen < args.length; subLen = 2 * subLen) {
			mergeDivide(args, subLen, args.length);
			display(args);
		}
	}
	
	/**
	 * 归并非递归
	 * @param args
	 */
	public static void mergeSortNonRecursive2(int[] args){
        int len = 1;  
        //程序边界的处理非常重要  
        while(len <= args.length){  
            for(int i = 0 ; i+len <= args.length - 1 ;i += len*2){  
                int low = i;
                int mid = i+len-1; 
                int high = i+len*2-1;  
                if(high>args.length-1) {
                	high = args.length-1;  
                }
                merge(args, low, mid, high);  
            }  
              
            len *= 2;  
        } 
	}
	
	/**
	 * 归并排序递归
	 * @param args
	 * @param low
	 * @param high
	 * @return
	 */
	public static int[] mergeSortRecursive(int[] args , int low , int high){
		int mid = (low + high) / 2;
		if(low < high){
			mergeSortRecursive(args, low, mid); //左段递归
			mergeSortRecursive(args, mid+1, high); //右段递归
			merge(args, low, mid, high); //合并
		}
		return args;
	}
	
	public static int partition(int[] args , int low , int high){
		int pivotkey = args[low];
		while(low < high){
			while(low < high && args[high] >= pivotkey){//从后面起找到第一个比标杆小的，覆盖当前low位值
				high--;
			}
			args[low] = args[high];
			while(low < high && args[low] <= pivotkey){//从前面其找到第一个比标杆大的，覆盖当前high值
				low++;
			}
			args[high] = args[low];
		}
		args[low] = pivotkey;
		
		return low;
	}
	
	public static void quickSortRecursive(int[] args , int low , int high){
		if(low < high){
			int pivotloc = partition(args , low , high);
			quickSortRecursive(args, low, pivotloc - 1);
			quickSortRecursive(args, pivotloc + 1, high);
		}
	}
	
	public static void quickSortNonRecursive1(int[] args){
        Stack<Integer> index=new Stack<Integer>();  
        int start=0;  
        int end=args.length-1;  
          
        int pivotPos;  
              
        index.push(start);  
        index.push(end);  
              
        while(!index.isEmpty()){  
            end=index.pop();  
            start=index.pop();  
              
            pivotPos=partition(args,start,end);  
            if(start<pivotPos-1){  
                index.push(start);  
                index.push(pivotPos-1);  
            }  
            if(end>pivotPos+1){  
                index.push(pivotPos+1);  
                index.push(end);  
            }  
        }    
	}
	
	public static void quickSortNonRecursive2(int[] args){
        Stack<Integer> startStack=new Stack<Integer>();//保存当前划分的最高位  
        Stack<Integer> endStack=new Stack<Integer>();//保存当前划分的最低位  
        int start=0;  
        int end=args.length-1;  
              
        int pivotPos;  
          
        startStack.push(start);  
        endStack.push(end);  
          
        while(!startStack.isEmpty()){  
            start=startStack.pop();  
            end=endStack.pop();  
            pivotPos=partition(args, start, end);  
            if(start<pivotPos-1){  
                startStack.push(start);  
                endStack.push(pivotPos-1);  
            }  
            if(end>pivotPos+1){  
                startStack.push(pivotPos+1);  
                endStack.push(end);  
            }  
        }
	}
	
	/**
	 * 希尔排序插入算法--待验证
	 * @param args
	 * @param dep
	 */
	public static void shellInsert(int[] args , int dep){
		for (int i = dep + 1; i <= args.length; i++) {
			if(args[i] < args[i-dep]){
				args[0] = args[i];
				for (int j = i - dep; j >  0 && args[0] < args[j]; j-=dep) {
					args[j + dep] = args[j];
				}
				args[i + dep] = args[0];
			}
		}
	}
	
	/**
	 * 希尔排序--待验证
	 * @param args
	 * @param div
	 */
	public static void shellSort(int[] args , int[] div){
		for (int i = 0; i < div.length; i++) {
			shellInsert(args , div[i]);
		}
	}
	
	/**
	 * 堆排序--构造大顶堆
	 * @param args
	 * @param lastIndex
	 */
	public static void creatMaxHeap(int[] args , int lastIndex){
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            // 保存当前正在判断的节点  
            int k = i;  
            // 若当前节点的子节点存在  
            while (2 * k + 1 <= lastIndex) {  
                // biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点  
                int biggerIndex = 2 * k + 1;  
                if (biggerIndex < lastIndex) {  
                    // 若右子节点存在，否则此时biggerIndex应该等于 lastIndex  
                    if (args[biggerIndex] < args[biggerIndex + 1]) {  
                        // 若右子节点值比左子节点值大，则biggerIndex记录的是右子节点的值  
                        biggerIndex++;  
                    }  
                }  
                if (args[k] < args[biggerIndex]) {  
                    // 若当前节点值比子节点最大值小，则交换2者得值，交换后将biggerIndex值赋值给k  
                    swap(args, k, biggerIndex);  
                    k = biggerIndex;  
                } else {  
                    break;  
                }  
            }
		}
	}
	
	public static void swap(int[] args , int i , int j){
		int temp = args[i];
		args[i] = args[j];
		args[j] = temp;
	}
	
	public static void heapSort(int[] args){
		for (int i = 0; i < args.length - 1; i++) {
			creatMaxHeap(args , args.length - i - 1);
			swap(args, 0, args.length - i - 1);
		}
	}

	public static void main(String[] args) {
		int[] arrays = new int[N];
		for (int i = 0; i < N; i++) {
			Random random = new Random();
			int value = 1 + random.nextInt(100);
			arrays[i] = value;
		}
		
//		int[] arrays = {54,35,48,36,27,12,44,44,8,14,26,17,28};
		
		System.out.print("source ==> ");
		display(arrays);
		
//		System.out.print("bubble ==> ");
//		bubbleSort(arrays);
		
//		System.out.print("select ==> ");
//		selectSort(arrays);
		
//		System.out.print("insert ==> ");
//		insertSort(arrays);
		
//		System.out.print("merge ==> ");
//		mergeSortNonRecursive(arrays);
		
//		System.out.print("merge ==> ");
//		mergeSortNonRecursive2(arrays);
		
//		System.out.print("merge ==> ");
//		mergeSortRecursive(arrays, 0, arrays.length -1);
		
//		System.out.print("quick ==> ");
//		quickSortRecursive(arrays, 0, arrays.length -1);
		
//		System.out.print("quick ==> ");
//		quickSortNonRecursive1(arrays);

//		System.out.print("quick ==> ");
//		quickSortNonRecursive2(arrays);
		
		System.out.print("heap ==> ");
		heapSort(arrays);
		
		display(arrays);
	}

}
