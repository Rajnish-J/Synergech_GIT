package StringAssn;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {
		String cities = "Mumbai, Chennai, Kolkata, Pune";

		StringTokenizer st = new StringTokenizer(cities, ",");

		System.out.println("List of cities:");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken().trim());
		}
	}
}
