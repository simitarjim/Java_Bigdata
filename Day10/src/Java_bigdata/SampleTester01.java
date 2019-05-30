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
		System.out.println("person无参数构造方法");
	}
	
	public Person(String name){
		this.name = name;
		System.out.println("person有参数构造方法");
	}
	
	public void print() {
		System.out.println(this.name);
	}
}

class Teacher extends Person{
	public Teacher() {
		System.out.println("teacher的无参构造器");
	}
	public Teacher(String name) {
		//this.name = name;
		//或者可以使用如下语句
		super(name);
		System.out.println("teacher的有参构造器");
	}
}