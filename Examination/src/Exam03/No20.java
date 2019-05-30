package Exam03;

public class No20 {
	public static void main(String[] args) {
		String[][] school = { { "星期一", "语文", "数学" }, { "星期二", "数学", "手工" }, { "星期三", "语文", "体育" },
				{ "星期四", "手工", "语文" }, { "星期五", "语文", "数学" } };
		for (int j = 0; j < school[j].length; j++) {
			for (int i = 0; i < school[i].length; i++) {

				System.out.print(school[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
