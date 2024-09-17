package streamProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assn_1 {
	public static void main(String[] args) {
		List<String> countries = new ArrayList<String>();
		countries.addAll(Arrays.asList("USA", "China", "India", "UK", "Germany"));
		List<Character> result = countries.stream().map(country -> country.charAt(country.length() - 1))
				.collect(Collectors.toList());
		System.out.println(result);
	}
}
