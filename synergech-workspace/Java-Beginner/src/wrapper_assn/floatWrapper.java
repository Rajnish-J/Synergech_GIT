package wrapper_assn;

public class floatWrapper {
	public static void main(String[] args) {
		float f1 = 123.45f;
		float f2 = 148.65f;

//	=> problem 1:
		Float o1 = f1;
		Float o2 = f2;
		System.out.println("First float object: " + o1);
		System.out.println("Second float object: " + o2);

		boolean res = o1.equals(o2);
		System.out.println("checking for equality: " + res);

//		=> problem 2:
		System.out.println("first HexaDecimal String: " + o1.toHexString(f1));
		System.out.println("Second hexaDecimal String: " + o2.toHexString(f2));
	}
}
