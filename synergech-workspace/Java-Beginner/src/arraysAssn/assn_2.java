package arraysAssn;

public class assn_2 {
	public static void main(String[] args) {
		int[][] A = { { 1, 4, 5 }, { 2, 1, 2 }, { 4, 5, 3 } };
		int[][] B = { { 2, 3, 4 }, { 3, 4, 2 }, { 2, 3, 2 } };
		int[][] res = new int[3][3];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				res[i][j] = A[i][j] + B[i][j];
			}
		}

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
	}
}
