package Exam03;

public class No18 {
	public static void main(String[] args) {
		int[][] arr = {{22,66,44},{77,33,88},{25,45,65},{11,66,99}};
		int sum = 0;
		for (int i = 0; i < (arr.length-1); i++) {
			for (int j = 0; j <= (arr[i].length-1); j++) {
				
				sum = sum +	arr[i][j];
			}
			
		}
		System.out.println("年销售总额为"+ sum);
	}

}
