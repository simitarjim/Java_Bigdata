package Java_bigdata01;

public class sampleTester01 {
	public static void main(String[] args) {
		Person bb = new Person();
		bb.name = "bb";
		bb.buy(10000, 12, 12, 1);
		bb.buy(10000, 12, 12, 2);
		bb.buy(10000, 12, 12, 3);
		bb.printAll();
	}

}

class Person {
	public String name;
	InterestBase[] its = new InterestBase[3];

	public void buy(double amount, double rateofYear, int months, int type) {
		if (type == 1) {
			AveragePlusInterest p = new AveragePlusInterest();
			p.compute(amount, rateofYear, months);
			its[0] = p;
		} else if (type == 2) {
			TotalPayedInterest p = new TotalPayedInterest();
			p.compute(amount, rateofYear, months);
			its[1] = p	;
		}else{
			MonthlyInterest p = new MonthlyInterest();
			p.compute(amount, rateofYear, months);
			its[2] = p;
		}
	}
	
	public void printAll() {
		for (int i = 0; i < its.length; i++) {
			its[i].print();
			System.out.println();
		}
	}

}
abstract class InterestBase{
	protected String name;	

	protected Interest[] interests ;

	public abstract void compute(double amount, double rateOfYear, int months);
	
	// print
	public void print(){
		System.out.println(this.name);
		for(int i=0; i<interests.length; i++){
			System.out.print("������" + interests[i].month + "\t");
			System.out.print("������Ϣ" + + interests[i].returnRate + "\t");
			System.out.print("��������" +  + interests[i].returnAmount+ "\t");
			System.out.print("��ʣ�����Ҫ����" +  + interests[i].leftRateAndAmount+ "\t");
			System.out.print("����Ϣ" +  + interests[i].totalRate+ "\t");
			System.out.print("�ܻ���" +  + interests[i].totalAmount+ "\t");
			System.out.println();
		}
	}
}

abstract class Temp01 extends InterestBase{

}

class AveragePlusInterest extends InterestBase{
	@Override
	public void compute(double amount, double rateOfYear, int months){
		this.name = "�ȶϢ";
		interests = new Interest[months];
		double monthRate = (rateOfYear) / 1200.0; // ������תΪ������

		int i = 0;
		double returnRateAndAmount = 0.0; // ������Ϣ
		double returnRate = 0.0; // ������Ϣ
		double returnAmount = 0.0; // ��������
		// ��Ϣ����
		//double totalRateIncome = (amount * months * monthRate * Math.pow((1 + monthRate), months))/ (Math.pow((1 + monthRate), months) - 1) - amount;

		double totalRateIncome = (amount * months * monthRate * Math.pow((1+monthRate), months)) / (Math.pow((1+monthRate) , months) - 1) - amount;
		double totalIncome = totalRateIncome + amount;
		double leftRateAndAmount = amount + totalRateIncome; // ʣ�౾��

		totalRateIncome = Math.round(totalRateIncome * 100.0) / 100.0;// ֧������Ϣ
		totalIncome = Math.round(totalIncome * 100) / 100.0;
		returnRateAndAmount = totalIncome / months; // ÿ�»��Ϣ
		returnRateAndAmount = Math.round(returnRateAndAmount * 100.0) / 100.0;// ÿ�»��Ϣ

		for (i = 1; i <= months; i++) {
			returnRate = (amount * monthRate * (Math.pow((1 + monthRate), months) - Math.pow((1 + monthRate), (i - 1))))
					/ (Math.pow((1 + monthRate), months) - 1);
			returnRate = Math.round(returnRate * 100.0) / 100.0;
			returnAmount = returnRateAndAmount - returnRate;
			returnAmount = Math.round(returnAmount * 100.0) / 100.0;
			leftRateAndAmount = leftRateAndAmount - returnRateAndAmount;
			leftRateAndAmount = Math.round(leftRateAndAmount * 100.0) / 100.0;
			if (i == months) {
				returnAmount = returnAmount + leftRateAndAmount;
				returnRate = returnRate - leftRateAndAmount;
				returnAmount = Math.round(returnAmount * 100.0) / 100.0;
				returnRate = Math.round(returnRate * 100.0) / 100.0;
				leftRateAndAmount = 0.0;
			}

			Interest it = new Interest();
			it.month = i;
			it.returnRate = returnRate;
			it.returnAmount = returnAmount;
			it.leftRateAndAmount = leftRateAndAmount;
			it.totalRate = totalRateIncome;
			it.totalAmount = totalIncome;
			interests[i - 1] = it;
		}

		//return interests;
	}

}

// һ���Ի�����Ϣ
class TotalPayedInterest extends InterestBase{
	@Override
	public void compute(double amount, double yearRate, int months){
		this.name = "һ���Ի�����Ϣ";
		
		interests = new Interest[1];
		double rateIncome = amount * (yearRate / 100.0 ) * ( months / 12.0);
		double totalIncome = amount + rateIncome;
		
		Interest it = new Interest();
		it.month = 1;
		it.returnRate = rateIncome;
		it.returnAmount = amount;
		it.leftRateAndAmount = 0;
		it.totalRate = rateIncome;
		it.totalAmount = rateIncome + amount;
		interests[0]=it;
		//return interests;
	}

}

// ���¸�Ϣ�����ڻ���
class MonthlyInterest extends InterestBase{
	@Override
	public void compute(double amount, double yearRate, int months){
		this.name = "���¸�Ϣ�����ڻ���";
		double rateIncome = amount * yearRate / 100.0 * (months / 12.0 ) ;
		double rateIncomeEve = rateIncome / months;
		double total = amount + rateIncome;

		interests = new Interest[months];
	
		for(int i = 1; i < months; i++){
			/*
			double[] interest = new double[6];
			interest[0] = i;// ����
			interest[1] = rateIncomeEve;// ������Ϣ
			interest[2] = 0;// ��������
			interest[3] = amount + rateIncome - (rateIncomeEve * i);// ��ʣ����ٱ�ϢҪ��
			interest[4] = rateIncome;// ����Ϣ
			interest[5] = rateIncome + amount;// �ܻ���
			interests[i-1] = interest;
			*/
			Interest it = new Interest();
			it.month = i;
			it.returnRate = rateIncomeEve;
			it.returnAmount = 0;
			it.leftRateAndAmount = amount + rateIncome - (rateIncomeEve * i);
			it.totalRate = rateIncome;
			it.totalAmount = rateIncome + amount;
			interests[i-1]=it;
		}
		/*
		double[] interest = new double[6];
		interest[0] = months;// ����
		interest[1] = rateIncomeEve;// ������Ϣ
		interest[2] = amount;// ��������
		interest[3] = amount + rateIncome - (rateIncomeEve * months) - amount;// ��ʣ����ٱ�ϢҪ��
		interest[4] = rateIncome;// ����Ϣ
		interest[5] = rateIncome + amount;// �ܻ���
		interests[months - 1] = interest;
		*/

		Interest it = new Interest();
		it.month = months;
		it.returnRate = rateIncomeEve;
		it.returnAmount = amount;
		it.leftRateAndAmount = amount + rateIncome - (rateIncomeEve * months) - amount;
		it.totalRate = rateIncome;
		it.totalAmount = rateIncome + amount;
		interests[months -1]=it;

		//return interests;
	}
}

class Interest{
	public int month;		//����
	public double returnRate; 	// ������Ϣ
	public double returnAmount; 	// ��������
	public double leftRateAndAmount; // ʣ�����Ҫ����ʣ�౾Ϣ��
	public double totalRate; 	// ����Ϣ
	public double totalAmount; 	// �ܻ���
	
}

