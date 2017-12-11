package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
	
	private Object subject;
	
	public DynamicProxy(Object object){
		this.subject = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before rent house , clean it");
		System.out.println("Method: "+method);
		method.invoke(subject, args);
		System.out.println("after rent house , get money");
		
		return null;
	}

}
