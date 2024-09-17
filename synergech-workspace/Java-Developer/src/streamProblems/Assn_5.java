package streamProblems;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;

public class Assn_5 {
	public static void main(String[] args) {
		Map<String, Integer> report = new HashMap<>();
		report.put("Tom", 89);
		report.put("Raj", 45);
		report.put("Jack", 39);
		report.put("Rama", 93);
		IntSummaryStatistics res = report.values().stream().mapToInt(Integer::intValue).summaryStatistics();
		System.out.println("Average math Mark: " + res.getAverage());
		System.out.println("Minimun math Mark: " + res.getMin());
		System.out.println("Maximum math Mark: " + res.getMax());
		System.out.println("Total math Mark: " + res.getSum());
	}
}
