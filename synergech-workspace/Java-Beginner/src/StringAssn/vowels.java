package StringAssn;

import java.util.Scanner;

public class vowels {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Enter the string: ");
		String ip = sc.next();
		int count = 0;

		for (int i = 0; i < ip.length(); i++) {
			char ch = ip.charAt(i);
			if (ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o'
					|| ch == 'U' || ch == 'u') {
				count++;
			}
		}
		System.out.println("The count of the vowels in the given String is: " + count);
	}
}