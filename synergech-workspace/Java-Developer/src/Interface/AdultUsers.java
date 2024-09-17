package Interface;

public class AdultUsers implements LibraryUser {

	@Override
	public void registerAccount(int age) {
		System.out.println((age > 12) ? "You have successfully registered under a adults account"
				: "Sorry, age must be greater than 12 to register an adults account");
	}

	@Override
	public void requestBook(int bookType) {
		System.out.println((bookType == 2) ? "Book Issued successfully, please return the book within 7 days"
				: "Oops, you are allowed to take only adults Fiction book");
	}

}
