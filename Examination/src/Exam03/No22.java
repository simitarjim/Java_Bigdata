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
		System.out.println("������8��ѧ���ĳɼ�:");
		for (int i = 0; i < score.length; i++) {
			System.out.println("�������" + (i + 1) + "��ѧ���ĳɼ�");
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
		System.out.println("�ܷ���" + total);
		System.out.println("ƽ������" + average);
		System.out.println("��ͷ���" + min);
		System.out.println("��߷���" + max);
		

	}

}
