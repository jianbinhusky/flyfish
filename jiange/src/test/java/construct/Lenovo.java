package construct;

import org.junit.Test;

import lombok.Getter;

public class Lenovo {
	@Getter
	private String str;
	
	public Lenovo(){
		System.out.println("lenovo");
	}
	
	public Lenovo(String str){
		System.out.println("lenovo " + str);
	}
	
//	@Test
//	public void createLenovo(){
//		new Lenovo();
//	}
	
	public static void main(String[] args){
		new Lenovo();
		new Lenovo("give me offer");
	}
}
