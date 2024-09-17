package MethodReferences;

import java.util.StringJoiner;

public class Assn_2 {

	public void joinStudentNames(String... names) {
		StringJoiner sj = new StringJoiner("-");

		for (String name : names) {
			sj.add(name);
		}

		System.out.println(sj.toString());
	}

	public static void main(String[] args) {
		Assn_2 vargsDemo = new Assn_2();

		vargsDemo.joinStudentNames("Jack", "John", "Tim", "Tom");
	}
}
