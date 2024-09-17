package com.wrapper.demo;

public class IntegerExample {
	public static void main(String[] args) {

		Integer num1 = new Integer(1234);
		Integer num2 = new Integer(4321);

//		=> problem 1:
		int c_num1 = num1.intValue();
		long c_num2 = num2.longValue();

		System.out.println(
				"The primitive value of the Integer" + c_num1 + " The primitive long value of the Integer = " + c_num2);

//		=> problem 2:
		if (num1.compareTo(num2) > 0) {
			System.out.println("The " + num1 + " is bigger than " + num2);
		} else {
			System.out.println("The " + num2 + " is bigger than " + num1);
		}

//		=> Problem 3:
		int maxValue = Integer.MAX_VALUE;
		int minValue = Integer.MIN_VALUE;

		System.out.println("Maximum Integer value= " + maxValue);
		System.out.println("Minimum Integer value= " + minValue);

//		=> Problem 4:
		// result
		String s = "4321";
		int convertedValue = Integer.parseInt(s);
		convertedValue += 200;

		System.out.println("The string converted to int and incremented by 200 is: " + convertedValue);
	}
}
