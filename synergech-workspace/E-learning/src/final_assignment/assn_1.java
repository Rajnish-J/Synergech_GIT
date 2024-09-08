package final_assignment;

import java.util.Scanner;

public class assn_1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the first number: ");
		int num1 = sc.nextInt();
		int sumNum1 = sum(num1);

		System.out.print("Enter the second number: ");
		int num2 = sc.nextInt();
		int sumNum2 = sum(num2);

		System.out.println("output: " + compare(num1, sumNum1, num2, sumNum2));
	}

	public static int sum(int num) {
		int sum = 0;
		while (num > 0) {
			int temp = num % 10;
			sum += temp;
			num /= 10;
		}
		return sum;
	}

	public static int compare(int num1, int sumNum1, int num2, int sumNum2) {
		int ret = 0;
		if (sumNum1 > sumNum2) {
			ret = num1;
		} else {
			ret = num2;
		}
		return ret;
	}
}
