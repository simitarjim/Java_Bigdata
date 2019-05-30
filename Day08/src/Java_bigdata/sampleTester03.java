package Java_bigdata;

public class sampleTester03 {
	public static void main(String[] args) {
		Person p1 = new Person();
		//p1.arms = null;
		//pl.arms = new Arm[3];
		p1.arms = null;	
		p1.getArms();
	}

}
class Person{
	Arm[] arms = new Arm[2];

	public Arm[] getArms() {
		return arms;
	}
	
}

class Arm{
	
}
