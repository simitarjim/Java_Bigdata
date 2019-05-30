package Java_bigdata01;

public class SampleTester06 {
	public static void main(String[] args) {
		C c = new C();
		int result = c.add(1, 2);
		System.err.println(result);
		c.print();
		c.show();
		c.showA1();
		System.out.println(c.name);
		
	}

}

interface A0{
	void show();
}
interface A1{
	void showA1();
}

interface A{
	//public static final
	String name = "不可变";
	int add(int a, int b);
	void print();
}

abstract class B implements A{
//如果要实现以下其中两个的一个方法，就要在类前面加abstract
	/*
	 * @Override public int add(int a, int b) { // TODO Auto-generated method stub
	 * return 0; }
	 */

	@Override
	public void print() {
		System.out.println("hello");
		
	}
}

class C extends B implements A0,A1{

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public void showA1() {
		System.out.println("hello1");
		
	}

	@Override
	public void show() {
		System.out.println("hello");		
	}
	
}