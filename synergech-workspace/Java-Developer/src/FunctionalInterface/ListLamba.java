package FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListLamba {
	public static void main(String[] args) {
		List<String> fruits = new ArrayList<String>();
		fruits.addAll(Arrays.asList("Apple", "Mango", "Orange", "Banana"));

		fruits.forEach((n) -> {
			System.out.println(n.charAt(0));
		});

	}
}
