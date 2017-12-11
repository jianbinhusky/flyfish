package aligo;

import java.util.LinkedList;
import java.util.List;

public class NeverMore {
	
	/**
	 * 打印100以内的素数
	 */
	public static boolean isPrime(int num){
		if(num == 1){
			return false;
		}
		
		long sqrtNum = (long) Math.sqrt(num);
		for (int i = 2; i <= sqrtNum; i++) {
			if(num % i == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void print99Low(){
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < i + 1; j++) {
				System.out.print(i + " * " + j + " = " +i*j + "\t");
			}
			System.out.println();
		}
	}
	
	public static void print99High(){
		for(int i = 1 , j = 1; j < 10; i++){
			System.out.print(i + " * " + j + " = " +i*j + "\t");
			if(j == i){
				i = 0;
				System.out.println();
				j++;
			}
		}
	}
	
	public static boolean isCircle(int num){
		int oldNum = num;
		int newNum = 0;
		while(num > 0){
			newNum = newNum * 10 + num % 10;
			num /= 10;
		}
		
		return oldNum == newNum;
	}
	
	public static boolean find(int[][] a , int t){
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j] == t){
					System.out.println("i = "+i + " j = "+j);
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean find2(int[][] array , int target){
		if(array[0][0] > target || array[0][array[0].length - 1] < target){
			return false;
		}else{
			if(array[array.length / 2][array[0].length / 2] > target){
				for (int i = 0; i <= array.length / 2; i++) {
					for (int j = 0; j <= array[0].length / 2; j++) {
						if(array[i][j] == target){
							return true;
						}
					}
				}
			}else if(array[array.length / 2][array[0].length / 2] < target){
				for (int i = array.length / 2; i < array.length; i++) {
					for (int j = array[0].length / 2; j < array[0].length; j++) {
						if(array[i][j] == target){
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public static int cycle(int total , int k){
		List<Integer> dataList = new LinkedList<Integer>();
		for (int i = 0; i < total; i++) {
			dataList.add(new Integer(i+1));
		}
		int index = -1;
		while(dataList.size() > 1){
			index = (index + k) % dataList.size();
			dataList.remove(index);
		}
		
		return 0;
	}

	public static void main(String[] args) {
		for (int i = 1; i < 100; i++) {
			if(isPrime(i)){
				System.out.print(i + ",");
			}
		}
		System.out.println();
//		print99Low();
//		print99High();
		
		for (int i = 10; i < 10000; i++) {
			if(isCircle(i)){
				System.out.print(i + " ");
			}
		}
		System.out.println();
		int[][] a = new int[5][5];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = i + j;
			}
		}
		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		int f = 5;
//		System.out.println(f + " in array?  " + find(a, f));
		System.out.println(f + " in array?  " + find2(a, f));
		
	}

}
