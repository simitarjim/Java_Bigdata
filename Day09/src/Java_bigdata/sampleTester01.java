package Java_bigdata;

public class sampleTester01 {
	public static void main(String[] args) {
		Demo d = new Demo();
		d.test();
		d.test(0);;
		
	}

}
class Demo{
	public void test() {
		System.out.println("test");
	}
	public void test(int a) {
		System.out.println("test2");
	}
}