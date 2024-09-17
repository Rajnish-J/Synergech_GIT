package StringAssn;

import java.util.Scanner;

public class convertCase {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a sentence: ");
		String input = sc.nextLine();

		String result = convertCase(input);

		System.out.println("Converted sentence: " + result);
	}

	public static String convertCase(String str) {
		StringBuilder convertedString = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isUpperCase(ch)) {
				convertedString.append(Character.toLowerCase(ch));
			} else if (Character.isLowerCase(ch)) {
				convertedString.append(Character.toUpperCase(ch));
			} else {
				convertedString.append(ch);
			}
		}

		return convertedString.toString();
	}

}
