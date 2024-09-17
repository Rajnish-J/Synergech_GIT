package Abstract;

public abstract class InterestCalculator {
	static double interest;

	public abstract void calculateInterest(double principle, double rate, int period);

	public static void display() {
		System.out.println(interest);
	}
}
