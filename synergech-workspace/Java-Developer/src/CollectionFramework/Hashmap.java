package CollectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Hashmap {
	static Set<String> students = new HashSet<String>();
	static Set<Integer> evenNumbers = new HashSet<>();
	static Set<Integer> copyEvenNumbers = new HashSet<>();

	public static void main(String[] args) {
		loadStudentNames("Rajnish", "sam", "raghul");
		System.out.println(populateEvenNumber(10));
		System.out.println(copyNumber());
	}

	public static void loadStudentNames(String name1, String name2, String name3) {
		students.addAll(Arrays.asList(name1, name2, name3));

		System.out.println(students);
	}

	public static Set populateEvenNumber(int N) {
		for (int i = 2; i <= N; i += 2) {
			evenNumbers.add(i);
		}

		return evenNumbers;
	}

	public static Set copyNumber() {
		copyEvenNumbers.addAll(evenNumbers);
		return copyEvenNumbers;
	}

}
