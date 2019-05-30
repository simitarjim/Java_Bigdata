package Java_bigdata;

public class SampleTester05 {

}
class Base{
	
}
interface A{
	public static final int aa =0 ;
	abstract int add();
	public abstract void print();
}

interface C{
	
}

interface A1 extends A{
	
}

interface A2 extends A{
	
}

class B extends Base implements A,C{

	@Override
	public int add() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
}