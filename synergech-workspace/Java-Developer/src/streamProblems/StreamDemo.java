package streamProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamDemo {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<String>();
		fruits.addAll(Arrays.asList("Apple", "Cocunut", "Grapes", "Cherry", "Orange"));

		List<Character> res = fruits.stream().map((s) -> s.charAt(0)).collect(Collectors.toList());
		res.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> Map Example:
		List<Character> res1 = fruits.stream().map((s) -> {
			char var = s.charAt(0);
			return ++var;
		}).collect(Collectors.toList());
		System.out.println("Map Example: ");
		res.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> pipeLining Example
		System.out.println("Pipelining Example: ");
		List<String> res2 = fruits.stream().map((obj) -> obj.toUpperCase()).filter((obj1) -> obj1.contains("C"))
				.collect(Collectors.toList());
		res2.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> limit example:
		System.out.println("Limit example: ");
		List<String> res3 = fruits.stream().limit(3).collect(Collectors.toList());
		res3.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> skip example:
		System.out.println("Skip example: ");
		res3 = fruits.stream().skip(2).collect(Collectors.toList());
		res3.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> sort Example: 
		System.out.println();
		res3 = fruits.stream().sorted().collect(Collectors.toList());
		res3.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> sort in descending order Example: 
		System.out.println();
		res3 = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		res3.forEach(System.out::println);
		System.out.println("-------------------------");
		System.out.println();

//		=> Map Conversion Example: 
		System.out.println();
		Map<String, String> m = fruits.stream().collect(Collectors.toMap((c) -> c + "key", (y) -> y + "value"));
		System.out.println(("Map -> " + m));
		System.out.println("-------------------------");
		System.out.println();

//		=> copying the one map to another map using stream:
		Map<String, String> m1 = new HashMap<String, String>();
		m1.put("India", "New Delhi");
		m1.put("US", "Washington");
		m1.put("Russia", "Moscow");
		m1.put("Japan", "Tokyo");

		Map<String, String> m2 = m1.entrySet().stream().filter((x) -> x.getKey().contains("a"))
				.collect(Collectors.toMap(i -> i.getKey(), i -> i.getValue()));
		System.out.println("Copied map: " + m2);
		System.out.println("-------------------------");
		System.out.println();

//		=> Map to String: This converts the map to a string by concatenating the key and value with — and finally combining all rows delimited with 'l'.
		String s = m1.entrySet().stream().map((k) -> k.getKey().concat("-").concat(k.getValue()))
				.collect(Collectors.joining("|"));
		System.out.println(s);
		System.out.println("-------------------------");
		System.out.println();

//		=> statistics function: Let us now see some statistics function. Assume the following map with country population
		Map<String, Integer> m4 = new HashMap<String, Integer>();
		m4.put("India", 100000);
		m4.put("US", 20000);
		m4.put("Russia", 30000);
		m4.put("Japan", 14000);

//		=> pre-defined statistics class:
		IntSummaryStatistics stat = m4.entrySet().stream().mapToInt(x -> x.getValue()).summaryStatistics();
		System.out.println("Total number of countries: " + stat.getCount());
		System.out.println("Average population of countries: " + stat.getAverage());
		System.out.println("Heavily populated of countries population: " + stat.getMax());
		System.out.println("Total population of countries: " + stat.getSum());
		System.out.println("Leastly populated countries population : " + stat.getMin());
		System.out.println("-------------------------");
		System.out.println();

		List<String> fruits_one = new ArrayList<String>();
		fruits.addAll(Arrays.asList("Apple", "Cocunut", "Grapes", "Cherry", "Orange", "Apple", "Cocunut"));

		List<String> distinct = fruits_one.stream().distinct().collect(Collectors.toList());
		System.out.println("Duplicate removed from the list" + distinct);
		System.out.println("-------------------------");
		System.out.println();

		List<Integer> num = new ArrayList<Integer>();
		num.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		int result = num.stream().reduce(0, (intermediateValue, elementValue) -> {
			intermediateValue = (elementValue % 2 == 0) ? intermediateValue + elementValue : intermediateValue;
			return intermediateValue;
		});
		System.out.println("sum of even numbers in the list: " + result);
	}

}
