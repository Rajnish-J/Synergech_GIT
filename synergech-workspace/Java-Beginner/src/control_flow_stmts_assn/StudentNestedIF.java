package control_flow_stmts_assn;

import java.util.Scanner;

public class StudentNestedIF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter marks: ");
		int marks = sc.nextInt();

		System.out.print("Enter student class (10 or 11): ");
		int studentClass = sc.nextInt();

		System.out.print("Enter city (Chennai or Delhi): ");
		String city = sc.next();

		double scholarship = calculateScholarship(marks, studentClass, city);
		System.out.println("Scholarship amount: " + scholarship);

//		scenario's:
		System.out.println("scenario 1: " + calculateScholarship(80, 10, "chennai"));
		System.out.println("scenario 2: " + calculateScholarship(70, 10, "delhi"));
		System.out.println("scenario 3: " + calculateScholarship(20, 10, "chennai"));
	}

	public static double calculateScholarship(int marks, int studentClass, String city) {
		double scholarship = 0;

		if (studentClass == 10) {
			if (marks < 60 && marks > 30) {
				scholarship = 30 * 15000 / 100;
				if (city.equals("chennai")) {
					scholarship -= 1000;
				} else {
					scholarship -= 3000;
				}
			} else if (marks < 90 && marks > 60) {
				scholarship = 50 * 15000 / 100;
			} else if (marks > 90) {
				scholarship = 70 * 15000 / 100;
			}
		} else if (studentClass == 11) {
			if (marks < 60 && marks > 30) {
				scholarship = 30 * 25000 / 100;
				if (city.equals("chennai")) {
					scholarship -= 1000;
				} else {
					scholarship -= 2000;
				}
			} else if (marks < 90 && marks > 60) {
				scholarship = 50 * 25000 / 100;
			} else if (marks > 90) {
				scholarship = 70 * 25000 / 100;
			}

		}

		return scholarship;
	}
}