package Basics_assn;

import java.util.Scanner;

public class area {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the radius: ");
		int radius = sc.nextInt();
		double area = 3.14 * radius * radius;
		System.out.println(area);
	}
}
