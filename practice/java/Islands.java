class Islands {
	public static void main(String[] args) {
		int mat[][] = {{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {0, 1, 0, 0}};

        islandCount(mat);
	}

	private static void islandCount(int[][] g) {
		int count = 0;
		int[][] visited = new int[g.length][g.length];

		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++) {
				if (visited[i][j] == 0 && g[i][j] == 1) {
					dfs(g, i, j, visited);
					count++;
				}
			}
		}

		System.out.println(count);
	}

	private static void dfs(int[][] g, int nodei, int nodej, int[][] visited) {
		visited[nodei][nodej] = 1;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int desti = nodei + i;
				int destj = nodej + j;
				if (desti >= 0 && desti < g.length && destj >= 0 && destj < g.length) {
					if (g[desti][destj] == 1 && visited[desti][destj] == 0) {
						dfs(g, desti, destj, visited);
					}
				}
			}
		}
	}
}