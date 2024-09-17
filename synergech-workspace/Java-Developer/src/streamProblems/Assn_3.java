package streamProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assn_3 {
	public static void main(String[] args) {
		List<String> countries = new ArrayList<>(Arrays.asList("India", "USA", "Ukraine", "UK", "Canada"));

		List<String> filteredCountries = countries.stream().map(country -> country.substring(0, 2))
				.filter(str -> str.contains("U")).collect(Collectors.toList());

		System.out.println("Filtered Countries: " + filteredCountries);
	}
}