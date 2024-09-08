// => problem 4:
package methodsAssn;

public class TaxCalculator {
	public static void main(String[] args) {

//		=>logic 1:
		PerishableGoods pg = new PerishableGoods();
		System.out.println("persihable goods => " + pg.createSalesTax(245.45, "chennai"));
		System.out.println("perishable VAT => " + pg.calculateVAT(245.45, "chennai"));
		System.out.println();

//		=>logic 2:
		NonPerishableGoods npg = new NonPerishableGoods();
		System.out.println("Non perishable goods => " + npg.createSalesTax(425.50, "Mumbai"));
		System.out.println("Non perishable VAT => " + npg.calculateVAT(425.50, "Mumbai"));
	}
}
