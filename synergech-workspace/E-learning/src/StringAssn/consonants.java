package StringAssn;

import java.util.Scanner;

public class consonants {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		String ip = sc.next();
		int count_vowels = 0;
		int count_consonants = 0;

		for (int i = 0; i < ip.length(); i++) {
			char ch = ip.charAt(i);
			if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o'
					|| ch == 'U' || ch == 'u') {
				count_vowels++;
			} else {
				count_consonants++;
			}
		}
		System.out.println("The count of the vowels in the given String is: " + count_vowels);
		System.out.println("The count of the consonants in the given String is: " + count_consonants);
	}
}
