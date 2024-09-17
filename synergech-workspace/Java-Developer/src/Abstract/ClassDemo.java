package Abstract;

public class ClassDemo {
	public static void main(String[] args) {
		simpleInterestCalculator si = new simpleInterestCalculator();
		compountInterestCalculator ci = new compountInterestCalculator();

		si.calculateInterest(20000, 7.5, 18);
		si.display();

		ci.calculateInterest(30000, 7.5, 24);
		ci.display();
	}
}
