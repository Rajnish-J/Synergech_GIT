package control_flow_stmts_assn;

import java.util.Scanner;

public class OddOrEven {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the number to check ODD or EVEN: ");
		int num = sc.nextInt();

		String[] res = { "even", "odd" };
		System.out.println(res[num & 1]);
	}
}
