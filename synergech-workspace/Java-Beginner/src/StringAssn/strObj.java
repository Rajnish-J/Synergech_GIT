package StringAssn;

import java.util.Scanner;

public class strObj {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the first string: ");
		String str1 = sc.next();
		System.out.print("Enter the second string: ");
		String str2 = sc.next();

//		=> problem 1:
		System.out.println("two string concatination: " + str1.concat(str2));

//		=> problem 2:
		System.out.println("checking the two string equal or not: " + str1.equals(str2));

//		=> problem 3:
		String f3_str1 = str1.substring(0, 3);
		String l3_str2 = str2.substring(0, 3);
		System.out.println("concatination of first three letters: " + f3_str1.concat(l3_str2));

//		=> problem 4:
		System.out.println("length of the first string: " + str1.length());
	}
}
