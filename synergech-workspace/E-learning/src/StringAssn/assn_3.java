package StringAssn;

import java.util.Scanner;

public class assn_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the String: ");
		String ip = sc.next();

		for (int i = ip.length() - 1; i >= 0; i--) {
			System.out.print(ip.charAt(i));
		}
	}
}
