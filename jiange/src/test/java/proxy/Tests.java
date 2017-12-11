package proxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class Tests {
	
	@Test
	public void testProxy(){
		Subject realSubject = new RealSubject();
		
		InvocationHandler handler = new DynamicProxy(realSubject);
		
		Subject subject = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		
		subject.rent();
		subject.hello("world");
		
		System.out.println(subject instanceof Proxy);
		System.out.println(subject.getClass().toString());
		System.out.println(subject.getClass().getName());
		
		Field[] fields = subject.getClass().getDeclaredFields();
		for (Field field : fields) {
			System.out.println("field: " + field.getName());
		}
		
		Method[] methods = subject.getClass().getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("method: " + method.getName());
		}
		
		System.out.println(subject.getClass().getSuperclass());
		
		Class<?>[] iface = subject.getClass().getInterfaces();
		for (Class<?> i : iface) {
			System.out.println(i.getName());
		}
	}
}
