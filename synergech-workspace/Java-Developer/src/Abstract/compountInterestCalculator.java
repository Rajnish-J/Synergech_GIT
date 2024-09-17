package Abstract;

public class compountInterestCalculator extends InterestCalculator {

	@Override
	public void calculateInterest(double principle, double rate, int period) {
		this.interest = (principle) * (1 + (rate / 100)) / period;
	}

}
