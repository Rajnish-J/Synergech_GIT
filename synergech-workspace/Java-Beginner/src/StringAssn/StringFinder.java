package StringAssn;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringFinder {
	static Scanner sc = new Scanner(System.in);

	// Method 1: Create a new string with only the characters at odd indices
	public static String getOddIndexChars(String input) {
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < input.length(); i += 2) {
			result.append(input.charAt(i));
		}
		return result.toString();
	}

	// Method 2: Capitalize the first character of each word
	public static String capitalizeFirstChar(String input) {
		StringTokenizer tokenizer = new StringTokenizer(input, " ");
		StringBuilder result = new StringBuilder();

		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
		}

		return result.toString().trim();
	}

	// Method 3: Reverse string if its length is odd, otherwise return the original
	// string
	public static String reverseIfOddLength(String input) {
		if (input.length() % 2 != 0) {
			return new StringBuilder(input).reverse().toString();
		}
		return input;
	}

	public static void main(String[] args) {

//		=> Method 1
		String input1 = "example";
		System.out.println("Odd index characters: " + getOddIndexChars(input1));

//		=> Method 2
		String input2 = "hello world this is java";
		System.out.println("Capitalized first characters: " + capitalizeFirstChar(input2));

//		=> Method 3
		String input3 = "apple";
		System.out.println("Reversed or original string: " + reverseIfOddLength(input3));

		String input4 = "java";
		System.out.println("Reversed or original string: " + reverseIfOddLength(input4));
	}
}
