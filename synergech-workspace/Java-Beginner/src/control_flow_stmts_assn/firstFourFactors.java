package control_flow_stmts_assn;

import java.util.Scanner;

public class firstFourFactors {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the number: ");
		int num = sc.nextInt();
		int i = 0;
		int count = 0;

		while (i++ < 100) {
			if (i % num == 0) {
				System.out.println(i);
				count++;
				if (count == 4) {
					break;
				}
			} else {
				continue;
			}
		}
	}
}