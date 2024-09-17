package FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenNumberGenerator {
	public static void main(String[] args) {
		INumberGenerator gen = (n) -> {
			for (int i = 2; i <= n; i += 2) {
				System.out.println(i);
			}
		};

		gen.generate(10);

		System.out.println("------------------------");

		List<String> countries = new ArrayList<String>();
		countries.addAll(Arrays.asList("India", "Australia", "South Africa", "England", "New zealand", "Sri lanka",
				"Pakistan", "West Indies", "Bangladesh", "Afghanistan"));

		countries.forEach((obj) -> {
			if (obj.contains("s")) {
				System.out.println(obj);
			}
		});
	}
}
