package control_flow_stmts_assn;

import java.util.Scanner;

public class printTillZero {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the number: ");
		int num = sc.nextInt();

		while (num >= 0) {
			System.out.println(num);
			num--;
		}
	}
}
