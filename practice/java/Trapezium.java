class Trapezium {
	public static void main(String[] args) {
		int n = 5;
		int k = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j < i) {
					System.out.print("  ");
					continue;
				}

				System.out.print(k + "*");
				k++;
			}

			for (int j = 1; j <= n; j++) {
				if (j >= n + 2 - i) {
					System.out.print("  ");
					continue;
				}

				System.out.print(k+(n-i+1)*(n-i+1)-(n-i+1) + (j-1));
				if (j<n + 2 - i - 1) {
					System.out.print("*");
				}
			}

			System.out.println();
		}
	}
}