package Exam03;

import java.util.Scanner;

public class No21 {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		Scanner scanner = new Scanner(System.in);
		System.out.println("������ʮ������");
		for (int i = 0; i < arr1.length; i++) {
			
			System.out.println("�������"+(i+1)+"������");
			arr1[i] = scanner.nextInt();
			arr2[i] = arr1[i];
		} 
		System.out.println("�ڶ�������Ϊ:");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println( arr2[i]);
		}
			
		}
		
	}


