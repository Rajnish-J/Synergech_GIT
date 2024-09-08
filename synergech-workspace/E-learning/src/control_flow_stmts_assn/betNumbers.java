package control_flow_stmts_assn;

import java.util.Scanner;

public class betNumbers {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the start number: ");
		int start = sc.nextInt();

		System.out.print("Enter the end number: ");
		int end = sc.nextInt();

		if (start < end) {
			for (int i = start; i <= end; i++) {
				System.out.println(i);
			}
		} else {
			System.out.println("Start number cannot be smaller than end number");
		}
	}
}
