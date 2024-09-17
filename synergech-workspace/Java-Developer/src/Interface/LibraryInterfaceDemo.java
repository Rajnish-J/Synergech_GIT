package Interface;

public class LibraryInterfaceDemo {
	public static void main(String[] args) {
//		=> test case 1:
		LibraryUser k = new Kidusers();
		k.registerAccount(10);
		k.registerAccount(15);

		k.requestBook(1);
		k.requestBook(2);

		System.out.println();

//		=> test case 2:
		LibraryUser a = new AdultUsers();
		a.registerAccount(10);
		a.registerAccount(15);

		a.requestBook(1);
		a.requestBook(2);

	}
}
