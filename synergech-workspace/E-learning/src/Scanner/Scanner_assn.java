package Scanner;

import java.util.*;

public class Scanner_assn {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.print("Enter the Name: ");
		String name = sc.next();
		
		System.out.print("Enter the Age: ");
		int age = sc.nextInt();
		
		System.out.print("Enter the Salary: ");
		double sal = sc.nextDouble();
		
		System.out.println("Your name is " + name + " your age is " + age + " and your earnings " + sal);
	}
}
