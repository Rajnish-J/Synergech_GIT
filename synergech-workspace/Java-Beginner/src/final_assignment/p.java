package final_assignment;

import java.util.HashMap;
import java.util.Scanner;

public class p {

	// Method to calculate factorial of a number
	public static long factorial(int n) {
		long fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	// Method to calculate the number of distinct permutations
	public static long countDistinctPermutations(String word) {
		int n = word.length();

		// Create a frequency map to count occurrences of each character
		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		for (char c : word.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

		// Calculate total permutations (n!)
		long totalPermutations = factorial(n);

		// Divide by factorial of counts of each repeated character
		for (int count : frequencyMap.values()) {
			if (count > 1) {
				totalPermutations /= factorial(count);
			}
		}

		return totalPermutations;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String word = scanner.nextLine();

		long result = countDistinctPermutations(word);
		System.out.println("Number of distinct words that can be formed: " + result);
	}
}
