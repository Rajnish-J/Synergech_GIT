package Basics_assn;

import java.util.Scanner;

public class largestOfThree {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the first number: ");
		int n1 = sc.nextInt();

		System.out.print("Enter the second number: ");
		int n2 = sc.nextInt();

		System.out.print("Enter the third number: ");
		int n3 = sc.nextInt();

		if ((n1 > n2) && (n1 > n3)) {
			System.out.println(n1);
		} else if ((n2 > n1) && (n2 > n3)) {
			System.out.println(n2);
		} else {
			System.out.println(n3);
		}
	}
}