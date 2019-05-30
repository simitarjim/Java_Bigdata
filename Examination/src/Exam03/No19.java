package Exam03;

public class No19 {
	public static void main(String[] args) {
		double[][] interests = compute(10000, 12, 10);
		print(interests);
	}

public static double[][] compute(double amount, double yearRate,double months){
	double rateincome = amount*yearRate/100*(months/12);
	double rateincomeEve = rateincome/months;
	double total = amount + rateincome;

	double[][] interests = new double[(int) months][6];
	
	for (int i = 1; i < months; i++) {
		double[] interest = new double[6];
		interest[0] = i;
		interest[1] = rateincomeEve;
		interest[3] = amount + rateincome - (rateincomeEve * i);
		interest[4] = rateincome;
		interest[5] = rateincome + amount;
		interests[i-1] = interest;
	}

	double[] interest = new double[6];
	interest[0] = months;
	interest[1] = rateincomeEve;
	interest[2] = amount;
	interest[3] = amount + rateincome - (rateincomeEve * months) - amount;// ��ʣ����ٱ�ϢҪ��
	interest[4] = rateincome;
	interest[5] = rateincome + amount;
	interests[(int)months - 1] = interest;
	return interests;
}


	public static void print(double[][] interests) {
		for (int i = 0; i < interests.length; i++) {
			System.out.print("������" + interests[i][0] + "\t");
			System.out.print("������Ϣ" + +interests[i][1] + "\t");
			System.out.print("��������" + +interests[i][2] + "\t");
			System.out.print("��ʣ�����Ҫ����" + +interests[i][3] + "\t");
			System.out.print("����Ϣ" + +interests[i][4] + "\t");
			System.out.print("�ܻ���" + +interests[i][5] + "\t");
			System.out.println();
		}
	}

}
