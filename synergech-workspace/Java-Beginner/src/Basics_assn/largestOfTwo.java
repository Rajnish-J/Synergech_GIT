package Basics_assn;

import java.util.Scanner;

public class largestOfTwo {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the N1 number: ");
		int n1 = sc.nextInt();

		System.out.print("Enter the N2 number: ");
		int n2 = sc.nextInt();

		System.out.println((n1 > n2) ? "N1 is greater" : "N2 is greater");
	}
}