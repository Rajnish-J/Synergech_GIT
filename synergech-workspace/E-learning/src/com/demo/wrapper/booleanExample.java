package com.demo.wrapper;

public class booleanExample {
	public static void main(String[] args) {
		Boolean bool1 = new Boolean(true);
		Boolean bool2 = new Boolean(false);

//	=> problem 1:
		System.out.println(
				"The hashcode of bool 1 = " + bool1.hashCode() + " The hashcode of bool 2 = " + bool2.hashCode());
	}
}
