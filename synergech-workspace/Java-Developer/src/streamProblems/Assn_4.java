package streamProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assn_4 {
	public static void main(String[] args) {
		List<String> countries = new ArrayList<>(
				Arrays.asList("India", "USA", "Japan", "Australia", "India", "Canada"));

		List<String> distinctCountries = countries.stream().distinct().collect(Collectors.toList());

		System.out.println("Distinct Countries: " + distinctCountries);

		List<String> countries_one = new ArrayList<>(
				Arrays.asList("India", "USA", "Japan", "Australia", "India", "Canada"));

		List<String> skippedCountries = countries_one.stream().skip(3).collect(Collectors.toList());

		System.out.println("Countries after skipping first 3: " + skippedCountries);
	}
}
