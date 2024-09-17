package com.demo.shapes;

public class Circle {
	private float radius;
	private float pi;

	public Circle() {
		this.radius = 1.5f;
		System.out.println("Radius Set");
	}

	public Circle(float radius) {
		this.radius = radius;
		System.out.println("overloaded constructor radius set");
	}
}
