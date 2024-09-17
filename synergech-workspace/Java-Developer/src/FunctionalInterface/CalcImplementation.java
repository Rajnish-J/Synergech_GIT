package FunctionalInterface;

public class CalcImplementation {

	public static void main(String[] args) {
		ICalculator calc = (n, m) -> {
			return n + m;
		};

		int a = calc.add(10, 20);
		System.out.println("Output of the example Functinal Interface: " + a);
	}

}
