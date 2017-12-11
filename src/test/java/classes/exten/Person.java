package classes.exten;

public class Person {
	String name;
	
	public Person(){
		System.out.println(1);
	}
	
	public Person(String name){
		this.name = name;
		System.out.println(2);
	}
	
	public static void main(String[] args){
		
		System.out.println();
		Child c = new Child("xiaobinbin");
	}

}

class Child extends Person{
	Object obj;
	public Child(){
		System.out.println(3);
	}
	
	public Child(String name){
		Person p = new Person(name + "F");
		System.out.println(4);
	}
}
