package Exam03;

import java.util.Scanner;

public class No16 {
	public static void main(String[] args) {
			String[] week = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入1-7任意数字");
			int number1 = scanner.nextInt();
			if (number1 >= 0 & number1 <= 7) {
				switch (number1 - 1) {
				case 0:
					System.out.println(week[0]);
					break;
				case 1:
					System.out.println(week[1]);
					break;
				case 2:
					System.out.println(week[2]);
					break;
				case 3:
					System.out.println(week[3]);
					break;
				case 4:
					System.out.println(week[4]);
					break;
				case 5:
					System.out.println(week[5]);
					break;
				case 6:
					System.out.println(week[6]);
					break;
				}

			} else {
				System.out.println("请重新输入");
			}

		}


}
