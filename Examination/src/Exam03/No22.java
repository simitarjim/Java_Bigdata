package Exam03;

import java.util.Scanner;

public class No22 {
	public static void main(String[] args) {
		int[] score = new int[8];
		int total = 0;
		int average = 0;
		int max = score[0];
		int min = score[0];

		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入8个学生的成绩:");
		for (int i = 0; i < score.length; i++) {
			System.out.println("请输入第" + (i + 1) + "个学生的成绩");
			score[i] = scanner.nextInt();
		}
		for (int i = 0; i < score.length; i++) {
			if (score[i] > max) {
				max = score[i];
				System.out.println(max);
			}
		}
		for (int i = 0; i <= (score.length-1); i++) {
			
		
			if (score[i] < min) {
				min = score[i];
				System.out.println(min);
			}
			total = total + score[i];
		}
		average = total / (score.length);
		System.out.println("总分是" + total);
		System.out.println("平均分是" + average);
		System.out.println("最低分是" + min);
		System.out.println("最高分是" + max);
		

	}

}
