package methodsAssn;

public class PerishableGoods extends Goods {
//	=> problem 2:
	public static double createSalesTax(double price, String city) {
		double salesTax = 0;
		if (city.equals("chennai")) {
			salesTax = 10 * price / 100 + 5;
		}
		if (city.equals("Mumbai")) {
			salesTax = 15 * price / 100 + 25;
		}
		return salesTax;
	}
}
