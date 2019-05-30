package Exam03;

import java.util.Scanner;

public class No21 {
	public static void main(String[] args) {
		int[] arr1 = new int[10];
		int[] arr2 = new int[10];
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入十个整数");
		for (int i = 0; i < arr1.length; i++) {
			
			System.out.println("请输入第"+(i+1)+"个整数");
			arr1[i] = scanner.nextInt();
			arr2[i] = arr1[i];
		} 
		System.out.println("第二个数组为:");
		for (int i = 0; i < arr2.length; i++) {
			System.out.println( arr2[i]);
		}
			
		}
		
	}


