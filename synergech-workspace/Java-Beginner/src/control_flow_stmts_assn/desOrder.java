package control_flow_stmts_assn;

import java.util.Scanner;

public class desOrder {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the number: ");
		int num = sc.nextInt();

		do {
			System.out.println(num);
			num--;
		} while (num > 0);
	}
}
