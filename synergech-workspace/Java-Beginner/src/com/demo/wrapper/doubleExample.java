package com.demo.wrapper;

public class doubleExample {
	public static void main(String[] args) {
		Double num1 = new Double(10.50);
		Double num2 = new Double(100.50);

//	=> converting datatypes
		int c_num1 = num1.intValue();
		float c_num2 = num2.floatValue();
		System.out.println(
				"The primitive value of the Double " + c_num1 + " The primitive long value of the Double " + c_num2);

//	=> problem 2 
		if (num1.compareTo(num2) > 0) {
			System.out.println("The " + num1 + " is bigger than " + num2);
		} else {
			System.out.println("The " + num2 + " is bigger than " + num1);
		}

//	problem 3
		String s = "1246.34";
		Double d1 = new Double(s);
		d1 += 99.99;
		System.out.println(d1);
	}
}
