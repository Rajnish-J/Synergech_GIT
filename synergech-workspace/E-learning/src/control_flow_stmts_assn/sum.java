package control_flow_stmts_assn;

public class sum {
	public static void main(String[] args) {
		int sum = 0;
		int i = 10;
		do {
			sum += i;
			i--;
		} while (i > 0);
		System.out.println(sum);
	}
}
