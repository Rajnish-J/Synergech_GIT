package com.demo.tax;

import java.util.Scanner;

public class IncomeTaxCalculator {
	static Scanner sc = new Scanner(System.in);
	float basicPay;
	boolean citizenship;

	public static void main(String[] args) {

		IncomeTaxCalculator i = new IncomeTaxCalculator();

		i.basicPay = sc.nextFloat();

		float incomeTax = 10 * (i.basicPay) / 100;

		System.out.println("The Income Tax of the employee for the " + i.basicPay + " is " + incomeTax);

		int nettPay = (int) (i.basicPay - incomeTax);

		System.out.println("The nett Pay of the employee " + nettPay);

		if (i.basicPay > 200000) {
			i.citizenship = true;
		} else {
			i.citizenship = false;
		}

		System.out.println("The salary and citizenship eligiblity: " + i.citizenship);

	}
}
