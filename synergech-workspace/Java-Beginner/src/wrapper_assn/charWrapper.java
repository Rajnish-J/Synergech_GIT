package wrapper_assn;

public class charWrapper {
	public static void main(String[] args) {
//	=>problem 1:
		Character c1 = 'b';
		System.out.println("uppercase object: " + c1.toUpperCase(c1));

//		=> problem 2:
		Character c2 = 'c';
		System.out.println("Checking for lowercase: " + c2.isLowerCase(c2));
		System.out.println("checking for number: " + c2.isDigit(c2));
		System.out.println("checking for whitespaces: " + c2.isWhitespace(c2));
	}
}