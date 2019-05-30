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
		System.out.println("父亲");
		
	}
}
class Child extends Parent{
	//重写了父类的demo
	@Override
	void demo() {
		System.out.println("儿子");
	}
	
}