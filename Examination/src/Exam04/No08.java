package Exam04;

public class No08 {
	
	public static void main(String[] args) {
		Marriage pursuer1 = new Marriage();
		pursuer1.pretty = 51;
		pursuer1.ugly = 49;
		//Girl[] totalgirls = new Girl[pursuer1.pretty+pursuer1.ugly];
		Girl[] totalgirls = new Girl[7];
		Girl p1 = new Girl();
		p1.name = "a";
		p1.cook = true;
		Girl p2 = new Girl();
		p2.name = "b";
		p2.cook = true;
		Girl p3 = new Girl();
		p3.name = "c";
		p3.cook = false;
		Girl p4 = new Girl();
		p4.name = "d";
		p4.cook = true;
		Girl p5 = new Girl();
		p5.name = "e";
		p5.cook = false;
		Girl p6 = new Girl();
		p6.name = "f";
		p6.cook = true;
		Girl p7 = new Girl();
		p7.name = "g";
		p7.cook = true;
		totalgirls[0] = p1;
		totalgirls[1] = p2;
		totalgirls[2] = p3;
		totalgirls[3] = p4;
		totalgirls[4] = p5;
		totalgirls[5] = p6;
		totalgirls[6] = p7;
		pursuer1.totalgirls=totalgirls;
		pursuer1.marriage();

		
	
		
		
	}

}


