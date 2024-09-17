package Abstract;

public class BankManager {
	public static void main(String[] args) {
		ABC_Bank a = new ABC_Bank();
		XYZ_bank x = new XYZ_bank();

		a.openAccountProcess();
		a.closeAccountProcess();

		x.openAccountProcess();
		x.closeAccountProcess();
	}
}
