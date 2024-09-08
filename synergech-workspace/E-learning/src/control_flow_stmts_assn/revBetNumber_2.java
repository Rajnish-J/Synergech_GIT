package control_flow_stmts_assn;

import java.util.Scanner;

public class revBetNumber_2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the start number: ");
		int start = sc.nextInt();

		System.out.print("Enter the end number: ");
		int end = sc.nextInt();

		if (end >= start) {
			for (int i = end; i >= start; i -= 2) {
				System.out.println(i);
			}
		} else {
			System.out.println("End number cannot be smaller than Start number");
		}
	}
}
