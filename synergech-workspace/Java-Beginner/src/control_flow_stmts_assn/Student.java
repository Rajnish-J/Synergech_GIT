package control_flow_stmts_assn;

import java.util.Scanner;

class Student {

	// Method to calculate the scholarship based on class and marks
	public static void calculateScholarship(int studentClass, int marks) {
		int scholarshipAmount = 0;

		if (studentClass == 10) {
			if (marks > 30 && marks < 60) {
				scholarshipAmount = 30 * 15000 / 100;
			} else if (marks > 60 && marks < 90) {
				scholarshipAmount = 50 * 15000 / 100;
			} else if (marks >= 90) {
				scholarshipAmount = 70 * 15000 / 100;
			}
		} else if (studentClass == 11) {
			if (marks > 30 && marks < 60) {
				scholarshipAmount = 30 * 25000 / 100;
			} else if (marks > 60 && marks < 90) {
				scholarshipAmount = 50 * 25000 / 100;
			} else if (marks >= 90) {
				scholarshipAmount = 70 * 25000 / 100;
			}
		} else if (studentClass == 12) {
			if (marks > 30 && marks < 60) {
				scholarshipAmount = 30 * 30000 / 100;
			} else if (marks > 60 && marks < 90) {
				scholarshipAmount = 50 * 30000 / 100;
			} else if (marks >= 90) {
				scholarshipAmount = 70 * 30000 / 100;
			}
		}

		// Print the scholarship amount
		System.out.println("The scholarship amount for class " + studentClass + " and marks " + marks + " is: "
				+ scholarshipAmount);
	}

	// Main method to test different scenarios
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Input marks and class from the user
		System.out.print("Enter marks: ");
		int marks = sc.nextInt();

		System.out.print("Enter class (10, 11, or 12): ");
		int studentClass = sc.nextInt();

		// Calculate and print the scholarship
		calculateScholarship(studentClass, marks);

		// Testing with different scenarios
		System.out.println("output for all scenario's");
		System.out.println("\nScenario 1: ");
		calculateScholarship(10, 80);

		System.out.println("\nScenario 2: ");
		calculateScholarship(10, 70);

		System.out.println("\nScenario 3: ");
		calculateScholarship(10, 20);

		System.out.println("\nScenario 4: ");
		calculateScholarship(11, 80);

		System.out.println("\nScenario 5: ");
		calculateScholarship(11, 70);

		System.out.println("\nScenario 6: ");
		calculateScholarship(11, 20);

		System.out.println("\nScenario 7: ");
		calculateScholarship(12, 80);

		System.out.println("\nScenario 8: ");
		calculateScholarship(12, 70);

		System.out.println("\nScenario 9: ");
		calculateScholarship(12, 20);

	}
}
