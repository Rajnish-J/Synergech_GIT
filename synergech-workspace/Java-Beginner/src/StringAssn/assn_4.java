package StringAssn;

import java.util.Scanner;

public class assn_4 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		String input = sc.next();

//		=>problem 1:
		if (input.length() >= 4) {
			System.out.println(input.charAt(3));
		} else {
			System.out.println("The given String length is lesser than 4");
		}

//		=>problem 2:
		System.out.print("Enter a character to find its first occurrence: ");
		char firstChar = sc.next().charAt(0);
		int firstIndex = input.indexOf(firstChar);
		if (firstIndex != -1) {
			System.out.println("First occurrence of '" + firstChar + "': " + firstIndex);
		} else {
			System.out.println("Character '" + firstChar + "' not found in the string.");
		}

//		=>problem 3:
		if (input.isEmpty()) {
			System.out.println("String is Empty");
		} else {
			System.out.println("String is not Empty");
		}

//		=>problem 4:
		System.out.print("Enter a character to find its last occurrence: ");
		char lastChar = sc.next().charAt(0);
		int lastIndex = input.lastIndexOf(lastChar);
		if (lastIndex != -1) {
			System.out.println("Last occurrence of '" + lastChar + "': " + lastIndex);
		} else {
			System.out.println("Character '" + lastChar + "' not found in the string.");
		}

//		=>problem 5:
		System.out.print("Enter a string to split based on '|': ");
		String[] splitString = sc.nextLine().split("|");
		System.out.println("Split result:");
		for (String part : splitString) {
			System.out.println(part);
		}

//		=>problem 6:
		if (input.contains("Hello")) {
			System.out.println("Substring 'llo' from 'Hello': " + input.substring(2, 5));
		} else {
			System.out.println("'Hello' not found in the input string.");
		}

//		=>problem 7:
		System.out.println("Uppercase string: " + input.toUpperCase());

//		=>problem 8:
		if (input == null) {
			System.out.println("The string is null.");
		} else {
			System.out.println("The string is not null.");
		}
	}
}
