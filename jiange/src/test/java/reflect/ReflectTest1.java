package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import file.Person;

public class ReflectTest1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
//		Class<Person> c1 = (Class<Person>) Class.forName("file.Person");
		
//		Class<Person> c1 = Person.class;
		
		Person p = new Person();
		Class<Person> c1 = (Class<Person>) p.getClass();
		
		System.out.println("name is " + c1.getName());
//		Method[] m = c1.getMethods();
		Method[] m = c1.getDeclaredMethods();
		for (Method method : m) {
			System.out.println("method is "+method);
		}
		
//		Field[] f = c1.getFields();
		Field[] f = c1.getDeclaredFields();
		for (Field field : f) {
			System.out.println("field is "+field);
		}
		Person p1 = c1.newInstance();
		p1.setAge(22);
		Field f1 = c1.getDeclaredField("sex");
		f1.set(p1, 1);
		System.out.println(p1.sex);
		System.out.println(f1.getName());
		
		Method m1 = c1.getDeclaredMethod("getAge", null);
		
		System.out.println(m1.invoke(p1, null));
	}

}
