package CollectionFramework;

import java.util.ArrayList;
import java.util.List;

public class EvenNumberGenerator {
	static List<Integer> EvenNumbers = new ArrayList<Integer>();

	public static void main(String[] args) {
		EvenNumberGenerator n = new EvenNumberGenerator();
		n.StoreEvenNumbers(20);
		n.EvenNumberGenerator();
		System.out.println(n.retreiveEvenNumber(4));
		System.out.println(n.retreiveEvenNumber(15));

	}

	public List StoreEvenNumbers(int N) {
		for (int i = 2; i <= N; i += 2) {
			EvenNumbers.add(i);
		}
		return EvenNumbers;
	}

	public void EvenNumberGenerator() {
		for (int obj : EvenNumbers) {
			System.out.println(obj * 2);
		}
	}

	public int retreiveEvenNumber(int N) {
		int ret = 0;
		for (int obj : EvenNumbers) {
			if (obj == N) {
				ret = obj;
			}
		}
		return ret;
	}
}
