package file;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 748399431506731368L;
	@Getter
	@Setter
	private String name;
	@Getter
	@Setter
	private int age;
	
	public int sex;
	
	public String toString(){
		return "Person[name = "+name + " , age = " + age +"]";
	}
}
