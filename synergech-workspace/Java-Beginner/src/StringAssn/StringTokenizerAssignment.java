package StringAssn;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerAssignment {

	// Task 1: Print each word on a separate line
	public static void printWords(String sentence) {
		StringTokenizer tokenizer = new StringTokenizer(sentence, " ");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
	}

	// Task 2: Count and print the number of words in the sentence
	public static void countWords(String sentence) {
		StringTokenizer tokenizer = new StringTokenizer(sentence, " ");
		System.out.println("Number of words: " + tokenizer.countTokens());
	}

	// Task 3: Concatenate all tokens that start with a vowel
	public static String concatenateVowelWords(String sentence) {
		StringTokenizer tokenizer = new StringTokenizer(sentence, "-");
		StringBuilder result = new StringBuilder();

		while (tokenizer.hasMoreTokens()) {
			String word = tokenizer.nextToken();
			char firstChar = Character.toLowerCase(word.charAt(0));
			if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
				result.append(word).append(" ");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Task 1: Accept sentence and print each word
		System.out.print("Enter a sentence: ");
		String sentence1 = scanner.nextLine();
		printWords(sentence1);

		// Task 2: Accept sentence and count words
		System.out.print("\nEnter a sentence to count words: ");
		String sentence2 = scanner.nextLine();
		countWords(sentence2);

		// Task 3: Accept delimited string and concatenate tokens starting with a vowel
		System.out.print("\nEnter a delimited string (using '-'): ");
		String delimitedSentence = scanner.nextLine();
		String result = concatenateVowelWords(delimitedSentence);
		System.out.println("Concatenated words starting with a vowel: " + result);
	}
}
