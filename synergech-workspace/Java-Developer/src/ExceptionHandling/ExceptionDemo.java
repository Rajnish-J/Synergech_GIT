package ExceptionHandling;

import java.util.Scanner;

public class ExceptionDemo {
	static Scanner sc = new Scanner(System.in);
	static int[] A1 = new int[10];

	public void loadArrary() {
		for (int i = 0; i < A1.length; i++) {
			System.out.print("Enter the elements: ");
			A1[i] = sc.nextInt();
		}
	}

	public void printArrayElements(int index) {
		try {
			System.out.println("The element for the given index is: " + A1[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Array Index is wrong...");
		}
	}

	public static void main(String[] args) {
		ExceptionDemo e = new ExceptionDemo();
		e.loadArrary();
		e.printArrayElements(17);
	}
}
