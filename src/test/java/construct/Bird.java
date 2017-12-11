package construct;

import jdk.net.mindview.util.Print;

class Persion{
	public void eat(Apple apple){
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Peeler{
	static Apple peel(Apple apple){
		return apple;
	}
}

class Apple{
	Apple getPeeled(){
		Print.print("peeled .");
		return Peeler.peel(this);
	}
}

public class Bird {
	
	public void suck(){
		System.out.println("suck .. ");
	}
	
	public void fuck(){
		suck();
		this.suck();
	}

	public static void main(String[] args){
		Print.print(new Bird());
		Persion p = new Persion();
		Apple a = new Apple();
		p.eat(a);
		new Bird().fuck();
	}
}
