package methodsAssn;

public class NonPerishableGoods extends Goods {
//	=> problem 3:
	public static double createSalesTax(double price, String city) {
		double salesTax = 0;
		if (city.equals("chennai")) {
			salesTax = 5 * price / 100 - 5;
		}
		if (city.equals("Mumbai")) {
			salesTax = 25 * price / 100 - 25;
		}
		return salesTax;
	}
}
