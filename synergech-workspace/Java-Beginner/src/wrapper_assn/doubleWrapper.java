package wrapper_assn;

public class doubleWrapper {
	public static void main(String[] args) {
//		=> problem 1
		Double d1 = 20004.345;
		System.out.println("int value: " + d1.intValue());

//		=>problem 2
		double d2 = 1457.89;
		Double D1 = d2;
		System.out.println(Double.MAX_VALUE);
		String str = D1.toString();
		System.out.println("Double object String value: " + str);

	}
}
