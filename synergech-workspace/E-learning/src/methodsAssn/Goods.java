package methodsAssn;

public class Goods {

//	=>problem 1:
	public static double calculateVAT(double price, String city) {
		double VAT = 0;
		if (city.equals("chennai")) {
			VAT = 2.5 * price / 100;
		}
		if (city.equals("Mumbai")) {
			VAT = 1.5 * price / 100;
		}
		return VAT;
	}
}
