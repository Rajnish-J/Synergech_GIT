package Basics_assn;

import java.util.Scanner;

public class largestOfThree_Ternary {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the first number: ");
		int n1 = sc.nextInt();

		System.out.print("Enter the second number: ");
		int n2 = sc.nextInt();

		System.out.print("Enter the third number: ");
		int n3 = sc.nextInt();

		System.out.println(((n1 > n2) && (n1 > n3)) ? "N1 is greater"
				: ((n2 > n1) && (n2 > n3)) ? "N2 is greater" : "N3 is greater");
	}
}
