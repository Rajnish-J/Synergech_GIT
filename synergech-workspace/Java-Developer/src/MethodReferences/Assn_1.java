package MethodReferences;

import java.util.StringJoiner;

public class Assn_1 {
	public static void main(String[] args) {
		StringJoiner sj = new StringJoiner(",", "Colors:[ ", "]");
		sj.add("Red");
		sj.add("Green");
		sj.add("Yellow");
		sj.add("Pink");
		System.out.println("output: " + sj);
	}
}
