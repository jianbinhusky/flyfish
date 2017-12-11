package testJavaTest.javaValueTransfer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestReferenceTranfer1 {

	/**
	 * 2. 什么是引用
	　　Java 是传值还是传引用，问题主要出在对象的传递上，因为 Java 中简单类型没有引用。
	既然争论中提到了引用这个东西，为了搞清楚这个问题，我们必须要知道引用是什么。
	　　简单的说，引用其实就像是一个对象的名字或者别名 (alias)，一个对象在内存中会请求一块空间来保存数据，
	根据对象的大小，它可能需要占用的空间大小也不等。访问对象的时候，我们不会直接是访问对象在内存中的数据，
	而是通过引用去访问。引用也是一种数据类型，我们可以把它想象为类似 C 语言中指针的东西，
	它指示了对象在内存中的地址——只不过我们不能够观察到这个地址究竟是什么。
	　　如果我们定义了不止一个引用指向同一个对象，那么这些引用是不相同的，
	因为引用也是一种数据类型，需要一定的内存空间来保存。但是它们的值是相同的，都指示同一个对象在内存的中位置。比如
	
	String a = "Hello";
	String b = a;

　　这里，a 和 b 是不同的两个引用，我们使用了两个定义语句来定义它们。但它们的值是一样的，都指向同一个对象 "Hello"。
	也许你还觉得不够直观，因为 String 对象的值本身是不可更改的 (像 b = "World"; b = a; 
	这种情况不是改变了 "World" 这一对象的值，而是改变了它的引用 b 的值使之指向了另一个 String 对象 a)。
	 */
	public static void main(String[] args) {
		StringBuffer a = new StringBuffer("Hello");
		StringBuffer b = a;
		b.append(",World!");
		log.info("a value is "+a);
		log.info("a hashCode is "+a.hashCode());
		log.info("b hashCode is "+b.hashCode());
		log.info("a toString is "+a.toString());
		log.info("b toString is "+b.toString());

		TestReferenceTranfer1 t1 = new TestReferenceTranfer1();
		System.out.println(t1.hashCode());
		
		/**
		 * 　　这个例子中 a 和 b 都是引用，当改变了 b 指示的对象的值的时候，从输出结果来看，a 所指示的对象的值也改变了。所以，a 和 b 都指向同一个对象即包含 "Hello" 的一个 StringBuffer 对象。
　　这里描述了两个要点：
1》. 引用是一种数据类型，保存了对象在内存中的地址，这种类型即不是我们平时所说的简单数据类型也不是类实例(对象)； 
2》. 不同的引用可能指向同一个对象，换句话说，一个对象可以有多个引用，即该类类型的变量。
		 */

	}

}
