package Interface;

public class Kidusers implements LibraryUser {

	@Override
	public void registerAccount(int age) {
		System.out.println((age < 12) ? "You have successfully registered under a kids account"
				: "Sorry, age must be less than 12 to register a kids account");
	}

	@Override
	public void requestBook(int bookType) {
		System.out.println((bookType == 1) ? "Book Issued successfully, please return the book within 10 days"
				: "Oops, you are allowed to take only kids book");
	}

}
