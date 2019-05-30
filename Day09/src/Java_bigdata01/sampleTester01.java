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
			System.out.print("期数：" + interests[i].month + "\t");
			System.out.print("偿还利息" + + interests[i].returnRate + "\t");
			System.out.print("偿还本金" +  + interests[i].returnAmount+ "\t");
			System.out.print("还剩余多少要还：" +  + interests[i].leftRateAndAmount+ "\t");
			System.out.print("总利息" +  + interests[i].totalRate+ "\t");
			System.out.print("总还款" +  + interests[i].totalAmount+ "\t");
			System.out.println();
		}
	}
}

abstract class Temp01 extends InterestBase{

}

class AveragePlusInterest extends InterestBase{
	@Override
	public void compute(double amount, double rateOfYear, int months){
		this.name = "等额本息";
		interests = new Interest[months];
		double monthRate = (rateOfYear) / 1200.0; // 年利率转为月利率

		int i = 0;
		double returnRateAndAmount = 0.0; // 偿还本息
		double returnRate = 0.0; // 偿还利息
		double returnAmount = 0.0; // 偿还本金
		// 利息收益
		//double totalRateIncome = (amount * months * monthRate * Math.pow((1 + monthRate), months))/ (Math.pow((1 + monthRate), months) - 1) - amount;

		double totalRateIncome = (amount * months * monthRate * Math.pow((1+monthRate), months)) / (Math.pow((1+monthRate) , months) - 1) - amount;
		double totalIncome = totalRateIncome + amount;
		double leftRateAndAmount = amount + totalRateIncome; // 剩余本金

		totalRateIncome = Math.round(totalRateIncome * 100.0) / 100.0;// 支付总利息
		totalIncome = Math.round(totalIncome * 100) / 100.0;
		returnRateAndAmount = totalIncome / months; // 每月还款本息
		returnRateAndAmount = Math.round(returnRateAndAmount * 100.0) / 100.0;// 每月还款本息

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

// 一次性还本付息
class TotalPayedInterest extends InterestBase{
	@Override
	public void compute(double amount, double yearRate, int months){
		this.name = "一次性还本付息";
		
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

// 按月付息，到期还本
class MonthlyInterest extends InterestBase{
	@Override
	public void compute(double amount, double yearRate, int months){
		this.name = "按月付息，到期还本";
		double rateIncome = amount * yearRate / 100.0 * (months / 12.0 ) ;
		double rateIncomeEve = rateIncome / months;
		double total = amount + rateIncome;

		interests = new Interest[months];
	
		for(int i = 1; i < months; i++){
			/*
			double[] interest = new double[6];
			interest[0] = i;// 期数
			interest[1] = rateIncomeEve;// 偿还利息
			interest[2] = 0;// 偿还本金
			interest[3] = amount + rateIncome - (rateIncomeEve * i);// 还剩余多少本息要还
			interest[4] = rateIncome;// 总利息
			interest[5] = rateIncome + amount;// 总还款
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
		interest[0] = months;// 期数
		interest[1] = rateIncomeEve;// 偿还利息
		interest[2] = amount;// 偿还本金
		interest[3] = amount + rateIncome - (rateIncomeEve * months) - amount;// 还剩余多少本息要还
		interest[4] = rateIncome;// 总利息
		interest[5] = rateIncome + amount;// 总还款
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
	public int month;		//期数
	public double returnRate; 	// 偿还利息
	public double returnAmount; 	// 偿还本金
	public double leftRateAndAmount; // 剩余多少要还（剩余本息）
	public double totalRate; 	// 总利息
	public double totalAmount; 	// 总还款
	
}

