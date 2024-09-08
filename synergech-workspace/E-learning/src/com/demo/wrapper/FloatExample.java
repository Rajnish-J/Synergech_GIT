package com.demo.wrapper;

public class FloatExample {
	public static void main(String[] args) {
		Float num1 = new Float(18.25f);
		Float num2 = new Float(12.65f);

//		=> problem 1
		if (num1.compareTo(num2) > 0) {
			System.out.println("The " + num1 + " is bigger than " + num2);
		} else {
			System.out.println("The " + num2 + " is bigger than " + num1);
		}
//		=> problem 2
		Float num3 = new Float("4321");
		System.out.println(num3 + 13.45f);

//		=> problem 3
		if (num1.isNaN()) {
			System.out.println("This is not a number");
		} else {
			System.out.println("This is a number");
		}

	}
}
