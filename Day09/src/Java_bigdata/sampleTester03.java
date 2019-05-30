package Java_bigdata;

public class sampleTester03 {
	public static void main(String[] args) {
		AveragePlusInterest p1 = new AveragePlusInterest();
		TotalPayInterest p2 = new TotalPayInterest();
		MonthlyInterest p3 = new MonthlyInterest();
		//遍历p1.interest
		p1.compute(10000, 12, 12);
		p1.print();
		System.out.println("\n");
		//遍历p2.interest
		p2.compute(10000, 12, 12);
		p2.print();
		System.out.println("\n");
		//遍历p3.interest
		p3.compute(10000, 12, 12);
		p3.print();
		
	
		
	}

}

class InterestBase {
	// 还款计划
	Interest[] interests;

	public void compute(double amount, double rateYear, int months) {

		System.out.println("Begin to compute");
	}
//print
	public void print() {
		for (int i = 0; i < interests.length; i++) {
			System.out.print("期数：" + interests[i].month + "\t");
			System.out.print("偿还利息" + +interests[i].returnRate + "\t");
			System.out.print("偿还本金" + +interests[i].returnAmount + "\t");
			System.out.print("还剩余多少要还：" + +interests[i].leftRateAndAmount + "\t");
			System.out.print("总利息" + +interests[i].totalRate + "\t");
			System.out.print("总还款" + +interests[i].totalAmount + "\t");
			System.out.println();
		}
	}
}

//等额本息
	class AveragePlusInterest extends InterestBase {
		@Override
		public void compute(double amount, double rateYear, int months) {

			interests = new Interest[months];
			double monthRate = (rateYear) / 1200.0; // 年利率转为月利率

			int i = 0;
			double returnRateAndAmount = 0.0; // 偿还本息
			double returnRate = 0.0; // 偿还利息
			double returnAmount = 0.0; // 偿还本金
			// 利息收益
			// double totalRateIncome = (amount * months * monthRate * Math.pow((1 +
			// monthRate), months))/ (Math.pow((1 + monthRate), months) - 1) - amount;

			double totalRateIncome = (amount * months * monthRate * Math.pow((1 + monthRate), months))
					/ (Math.pow((1 + monthRate), months) - 1) - amount;
			double totalIncome = totalRateIncome + amount;
			double leftRateAndAmount = amount + totalRateIncome; // 剩余本金

			totalRateIncome = Math.round(totalRateIncome * 100.0) / 100.0;// 支付总利息
			totalIncome = Math.round(totalIncome * 100) / 100.0;
			returnRateAndAmount = totalIncome / months; // 每月还款本息
			returnRateAndAmount = Math.round(returnRateAndAmount * 100.0) / 100.0;// 每月还款本息

			for (i = 1; i <= months; i++) {
				returnRate = (amount * monthRate
						* (Math.pow((1 + monthRate), months) - Math.pow((1 + monthRate), (i - 1))))
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

			// return interests;
		}

	}

//一次性还本付息
	class TotalPayInterest extends InterestBase {
		@Override
		public void compute(double amount, double rateYear, int months) {

			interests = new Interest[1];
			double rateIncome = amount * (rateYear / 100.0) * (months / 12.0);
			double totalIncome = amount + rateIncome;

			Interest it = new Interest();
			it.month = 1;
			it.returnRate = rateIncome;
			it.returnAmount = amount;
			it.leftRateAndAmount = 0;
			it.totalRate = rateIncome;
			it.totalAmount = rateIncome + amount;
			interests[0] = it;
			// return interests;

		}
	}

//按月付息，到期还本

	class MonthlyInterest extends InterestBase {
		@Override
		public void compute(double amount, double rateYear, int months) {
			double rateIncome = amount * rateYear / 100.0 * (months / 12.0);
			double rateIncomeEve = rateIncome / months;
			double total = amount + rateIncome;

			interests = new Interest[months];

			for (int i = 1; i < months; i++) {
				/*
				 * double[] interest = new double[6]; interest[0] = i;// 期数 interest[1] =
				 * rateIncomeEve;// 偿还利息 interest[2] = 0;// 偿还本金 interest[3] = amount +
				 * rateIncome - (rateIncomeEve * i);// 还剩余多少本息要还 interest[4] = rateIncome;// 总利息
				 * interest[5] = rateIncome + amount;// 总还款 interests[i-1] = interest;
				 */
				Interest it = new Interest();
				it.month = i;
				it.returnRate = rateIncomeEve;
				it.returnAmount = 0;
				it.leftRateAndAmount = amount + rateIncome - (rateIncomeEve * i);
				it.totalRate = rateIncome;
				it.totalAmount = rateIncome + amount;
				interests[i - 1] = it;
			}
			/*
			 * double[] interest = new double[6]; interest[0] = months;// 期数 interest[1] =
			 * rateIncomeEve;// 偿还利息 interest[2] = amount;// 偿还本金 interest[3] = amount +
			 * rateIncome - (rateIncomeEve * months) - amount;// 还剩余多少本息要还 interest[4] =
			 * rateIncome;// 总利息 interest[5] = rateIncome + amount;// 总还款 interests[months -
			 * 1] = interest;
			 */

			Interest it = new Interest();
			it.month = months;
			it.returnRate = rateIncomeEve;
			it.returnAmount = amount;
			it.leftRateAndAmount = amount + rateIncome - (rateIncomeEve * months) - amount;
			it.totalRate = rateIncome;
			it.totalAmount = rateIncome + amount;
			interests[months - 1] = it;

			// return interests;

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
