package control_flow_stmts_assn;

import java.util.Scanner;

public class StudentScholarship {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter marks: ");
		int marks = sc.nextInt();

		System.out.print("Enter student class (10, 11, or 12): ");
		int studentClass = sc.nextInt();

		System.out.println("scenario 1: " + scholarship(marks, studentClass));
		System.out.println("scenario 2: " + scholarship(60, 12));
		System.out.println("scenario 3: " + scholarship(30, 11));
		System.out.println("scenario 4: " + scholarship(30, 12));
	}

	public static double scholarship(int marks, int studentClass) {
		double scholarship = 0;

		switch (studentClass) {
		case 10:
			scholarship = marks * 15000 / 100;
			break;
		case 11:
			scholarship = marks * 25000 / 100;
			break;
		case 12:
			scholarship = marks * 30000 / 100;
			break;
		default:
			System.out.println("Invalid class. Please enter 10, 11, or 12.");
		}

		return scholarship;
	}
}