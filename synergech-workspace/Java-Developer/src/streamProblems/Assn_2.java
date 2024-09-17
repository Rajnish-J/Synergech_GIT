package streamProblems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assn_2 {
	public static void main(String[] args) {
		List<String> countries = Arrays.asList("USA", "China", "India", "UK", "Germany");
		String result = countries.stream().collect(Collectors.joining(","));
		System.out.println(result);
	}
}
