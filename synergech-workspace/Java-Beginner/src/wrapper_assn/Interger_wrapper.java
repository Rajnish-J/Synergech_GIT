package wrapper_assn;

public class Interger_wrapper {
	public static void main(String[] args) {
//	=> problem 1:
		String s = "100";
		Integer i1 = new Integer(s);
		System.out.println("String to Integer: " + i1);

//	=> problem 2:
		Long l1 = i1.longValue();
		String binaryString = Long.toBinaryString(l1);
		System.out.println("Long to binaryString " + binaryString);

//	=> problem 3:
		Integer i2 = new Integer(2450);
		String s1 = i2.toString();
		System.out.println("Integer to String " + s1);

		String octvalue = Integer.toOctalString(i2);
		System.out.println("Integer to octal value " + octvalue);

		Double d = i2.doubleValue();
		System.out.println("Integer to double value " + d);
	}
}
