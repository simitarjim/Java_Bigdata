package Java_bigdata;

public class SampleTester01 {
	public static void main(String[] args) {
		
//		Person p1 = new Person();
//		System.out.println(p1.name);
//		Person p2 = new Person("bb");
//		System.out.println(p2.name);
		Teacher t = new Teacher("lu");
		t.print();
	}

}
class Person{
	String name;
	
	public Person(){
		System.out.println("person�޲������췽��");
	}
	
	public Person(String name){
		this.name = name;
		System.out.println("person�в������췽��");
	}
	
	public void print() {
		System.out.println(this.name);
	}
}

class Teacher extends Person{
	public Teacher() {
		System.out.println("teacher���޲ι�����");
	}
	public Teacher(String name) {
		//this.name = name;
		//���߿���ʹ���������
		super(name);
		System.out.println("teacher���вι�����");
	}
}