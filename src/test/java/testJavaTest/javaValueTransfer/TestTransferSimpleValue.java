package testJavaTest.javaValueTransfer;

import lombok.extern.slf4j.Slf4j;

/**
 *  java是传值还是传引用，这个估计很多人至今都很糊涂
 * @author zookeeper
 *
 */
@Slf4j
public class TestTransferSimpleValue {

	/**
	 * 1. 简单类型是按值传递的
	 * Java 方法的参数是简单类型的时候，是按值传递的 (pass by value)。
	 * @param args
	   * 　　不难看出，虽然在 test(boolean) 方法中改变了传进来的参数的值，
	 * 但对这个参数源变量本身并没有影响，
	 * 即对 main(String[]) 方法里的 test 变量没有影响。
	 * 那说明，参数类型是简单类型的时候，是按值传递的。
	 * 以参数形式传递简单类型的变量时，实际上是将参数的值作了一个拷贝传进方法函数的，
	 * 那么在方法函数里再怎么改变其值，其结果都是只改变了拷贝的值，而不是源值。
	 */
	
	public static void test(boolean test){
		test = !test;
		log.info("In test(boolean):test= "+test);
	}
	
	public static void main(String[] args) {
		boolean test = true;
		log.info("Before test(boolean):test = "+test);
		test(test);
		log.info("After test(boolean):test = "+test);
	}

}
