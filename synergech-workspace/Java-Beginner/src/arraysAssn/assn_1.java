package arraysAssn;

import java.util.Scanner;

public class assn_1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] A = new int[51];
		int counter = 0;
		int incrementer = 0;

		while (counter < 51) {
			if (incrementer % 3 == 0) {
				A[counter] = incrementer;
				counter++;
			}
			incrementer++;
		}
		for (int obj : A) {
			System.out.print(obj + " ");
		}
	}
}
