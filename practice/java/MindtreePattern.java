class MindtreePattern {
	public static void main(String[] args) {
		int N = 10;

		int k = 1;
		for (int i = 1; i <= N; i++) {
			if (i % 2 != 0) {
				for (int j = k; j <= i + k - 1; j++) {
					System.out.print(j);
					if (j != i + k - 1)
						System.out.print("*");
				}
			} else {
				for (int j = i + k - 1; j >= k; j--) {
					System.out.print(j);
					if (j != k)
						System.out.print("*");
				}
			}

			k += i;
			System.out.println();
		}
	}
}