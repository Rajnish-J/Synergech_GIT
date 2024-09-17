package CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
	static List<String> names = new ArrayList<>();
	static List<Integer> evenNumbers = new ArrayList<Integer>();
	static List evenCopyNumbers = new ArrayList();

//	=> scenario 1:
	public static void loadStudentNames(String name1, String name2, String name3) {
		names.add(name1);
		names.add(name2);
		names.add(name3);
		System.out.println(names);
	}

//	=> scenario 2:
	public static List populateEvenNumber(int N) {
		for (int i = 0; i <= N; i++) {
			if (i % 2 == 0) {
				evenNumbers.add(i);
			}
		}
		return evenNumbers;
	}

//	=> scenario 3:
	public static List copyEvenNumber(List<Integer> evenNumbers2) {
		evenCopyNumbers.addAll(evenNumbers2);

		return evenCopyNumbers;
	}

	public static void main(String[] args) {

		loadStudentNames("Rajnish", "Raghul", "sam");
		populateEvenNumber(10);
		System.out.println(copyEvenNumber(evenNumbers));
	}
}
