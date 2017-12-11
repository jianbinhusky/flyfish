package testJavaTest.javaValueTransfer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestReferenceTranfer2 {

	/**
	 * 3. 对象是如何传递的呢
　　关于对象的传递，有两种说法，即“它是按值传递的”和“它是按引用传递的”。这两种说法各有各的道理，但是它们都没有从本质上去分析，即致于产生了争论。 　　
	既然现在我们已经知道了引用是什么东西，
	那么现在不妨来分析一下对象作是参数是如何传递的。
	 * @param args
	 */
	
	public static void test(StringBuffer str){
		//str.append(",World!");
		str = str.append(",World!");
	}
	
	public static void main(String[] args) {
		StringBuffer string = new StringBuffer("Hello");
		test(string);
		log.info("string is "+string);
		
		/**
		 * 　　test(string) 调用了 test(StringBuffer) 方法，并将 string 作为参数传递了进去。这里 string 是一个引用，这一点是勿庸置疑的。前面提到，引用是一种数据类型，而且不是对象，所以它不可能按引用传递，所以它是按值传递的，它么它的值究竟是什么呢？是对象的地址。
　　由此可见，对象作为参数的时候是按值传递的，对吗？错！为什么错，让我们看另一个例子：

		 */
	}

}
