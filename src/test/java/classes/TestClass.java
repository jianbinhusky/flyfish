package classes;

import classes.HuoGuo.Fangpi;

public class TestClass {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food f = new Food() {
			
			@Override
			void fit() {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		
		Fruit ft = new Fruit() {
			
			@Override
			public void smell() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void eat() {
				// TODO Auto-generated method stub
				
			}
		};
		
		Fuck s = new Fuck();
		System.out.println(s.bitch);
		s.bitch = "ssss bitch";
		System.out.println(s.bitch);
		
		HuoGuo hg = new HuoGuo();
		HuoGuo.Fangpi hhf = hg.new Fangpi();
		HuoGuo.Fangpi hf = new HuoGuo().new Fangpi();
		System.out.println(5 + ~10);
	
	}

}
