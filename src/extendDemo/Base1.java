package extendDemo;

public class Base1 {
	static{
		System.out.println("initialBase1");
	}
	public Base1(){
		System.out.println("Base1 constructor");
	}

	public static void main(String[] args) {
//		Sub1 sub = new Sub1();
//		sub.prt(); 
		/**
		 *  Base1 constructor
		 *  Sub1 constructor
		 *  Sub1 print
		*/
		
		Base1 base = new Sub1();
		base.prt();
	}
	
	public void prt(){
		System.out.println("Base1 print");
	}

}

class Sub1 extends Base1{
	static{
		System.out.println("initialSub1");
	}
	
	public Sub1(){
		System.out.println("Sub1 constructor");
	}
	
	public void prt(){
		System.out.println("Sub1 print");
	}
}
