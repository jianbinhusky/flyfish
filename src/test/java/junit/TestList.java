package junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestList {
	
	@Test
	public void testDoSomething(){
		List<?> list1 = new ArrayList();
		List list2 = new ArrayList();
		//List<E> list3 = new ArrayList<E>(); 
		//list1.add(1, null);
		//list1.add("str");
		list1.add(null);
		
		list2.add(1);
		list2.add("String");
		list2.add(2.28939);
		list2.add(Integer.parseInt("2"));
		for (Object object : list2) {
			System.out.println(object);
		}
		
		List<Long> list5 = new ArrayList<Long>();
		
		List<?> list4 = null;
		
		List<Long> list6 =  (List<Long>) list4; 
		
		
	}

}
