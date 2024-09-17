package Abstract;

public class simpleInterestCalculator extends InterestCalculator {

	@Override
	public void calculateInterest(double principle, double rate, int period) {
		this.interest = (principle * rate * period) / 100;
	}

}
