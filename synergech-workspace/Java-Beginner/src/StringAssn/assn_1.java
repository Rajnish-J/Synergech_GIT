package StringAssn;

import java.util.Scanner;

public class assn_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String ip = sc.next();

		for (int i = 0; i < ip.length(); i++) {
			System.out.println(ip.charAt(i));
		}
	}
}
