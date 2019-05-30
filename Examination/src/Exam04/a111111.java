package Exam04;

public class a111111 {

	public static void main(String[] args) {
		Company zuikc = new Company();
		zuikc.open();
		zuikc.checkAll();

	}
}

class Company {
	work[] workers = new work[5];

	public void open() {
		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3 = new Teacher();
		Machine m1 = new Machine();
		Machine m2 = new Machine();
		workers[0] = t1;
		workers[1] = t2;
		workers[2] = t3;
		workers[3] = m1;
		workers[4] = m2;
	}


	public void checkAll() {
		for (int i = 0; i < workers.length; i++) {
			workers[i].working();
		}
	}
}
interface work{
	void working();
}
class Person{
	String name;
	String age;
	void walk() {
		System.out.println("人走路");
	}
}

class Teacher extends Person implements work {
	public void working() {
		System.out.println("老师教学");
	}
}
class Student extends Person{
	
}

class Machine implements work{
	public void working() {
		System.out.println("在扫地");
	}
}