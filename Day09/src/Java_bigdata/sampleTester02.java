//override
package Java_bigdata;

public class sampleTester02 {
	public static void main(String[] args) {
		Parent p = new Child();
		p.demo();
		((Parent)p).demo();
	}

}

class Parent{
	void demo() {
		System.out.println("����");
		
	}
}
class Child extends Parent{
	//��д�˸����demo
	@Override
	void demo() {
		System.out.println("����");
	}
	
}