class MindtreePattern2 {
	public static void main(String[] args) {
		int n = 5;

		int num = n - 1;
		for (int i = 1; i <= n * 2 - 1; i++) {
			int last = (i > n) ? (n - i % n) : i;
			for (int j = 1; j <= last; j++) {
				System.out.print(num);
			}

			if (i >= n) {
				num--;
			} else {
				num++;
			}
			System.out.println();
		}
	}
}