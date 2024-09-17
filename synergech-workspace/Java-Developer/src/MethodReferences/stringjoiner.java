package MethodReferences;

import java.util.StringJoiner;

public class stringjoiner {
	public static void main(String[] args) {

//		=> method 1: normal constructor delimiter
		StringJoiner sj = new StringJoiner("|");
		sj.add("India");
		sj.add("Australia");
		sj.add("england");
		System.out.println("Joined String with delimiter: " + sj);

//		=> method 2: delimiter with prefix and suffix
		StringJoiner sj1 = new StringJoiner("-", "{Countries: ", "}");
		sj1.add("India");
		sj1.add("Australia");
		sj1.add("england");
		System.out.println("Joined String with delimiter and prefix,suffix: " + sj1);

//		=> method 3: adds new string in existing stringjoiner
		sj.add("japan");
		System.out.println("updated: " + sj);

//		=> method 4: merge method
		StringJoiner sj2 = new StringJoiner("|", "{Vegetables: ", "}");
		sj2.add("New delhi");
		sj2.add("canberra");
		sj2.add("London");
		sj2.add("Tokyo");
		sj2.merge(sj);
		System.out.println("Merged: " + sj2);
	}
}
