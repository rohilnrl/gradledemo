class ShortestMazePath {
	private static int min(int a, int b, int c, int d) {
		int min = a;
		if (b < a && b < c && b < d)
			min = b;
		if (c < b && c < a && c < d)
			min = c;
		if (d < c && d < b && d < a)
			min = d;
		return min;
	}

	private static int findPath(int[][] maze, int i, int j, int count, int prev) {
		int m = maze.length;
		int n = maze[0].length;

		if (maze[i][j] == 'd') {
			return count;
		} 

		System.out.println("Current: " + i + ", " + j + ", count: " + count);

		int upCount = Integer.MAX_VALUE;
		int downCount = Integer.MAX_VALUE;
		int leftCount = Integer.MAX_VALUE;
		int rightCount = Integer.MAX_VALUE;

		/*
		Code:-
		Left: 1
		Right: 2
		Up: 3
		Down: 4
		*/

		// Go left
		if (j > 0 && prev != 2 && maze[i][j - 1] == '*') {
			leftCount = findPath(maze, i, j - 1, count + 1, 1);
		}

		// Go right
		if (j < m - 1 && prev != 1 && maze[i][j + 1] == '*') {
			rightCount = findPath(maze, i, j + 1, count + 1, 2);
		}

		// Go up
		if (i > 0 && prev != 4 && maze[i - 1][j] == '*') {
			upCount = findPath(maze, i - 1, j, count + 1, 3);
		}

		// Go down
		if (i < n - 1 && prev != 3 && maze[i + 1][j] == '*') {
			downCount = findPath(maze, i + 1, j, count + 1, 4);
		}

		int minCount = min(upCount, downCount, leftCount, rightCount);
		return minCount;
	}

	public static void main(String[] args) {
		int[][] maze = {
			{'0', '*', '0', 's'},
    	    {'*', '0', '*', '*'},
        	{'0', '*', '*', '*'},
        	{'d', '*', '*', '*'}
		};

		int srci = 0;
		int srcj = 0;
		int desti;
		int destj;
		int[][] visited = new int[maze.length][maze[0].length];

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				visited[i][j] = 0;
				if (maze[i][j] == 's') {
					srci = i;
					srcj = j;
				} else if (maze[i][j] == 'd') {
					desti = i;
					destj = j;
				}
			}
		}

		int ans = findPath(maze, srci, srcj, 0, -1);
		System.out.println(ans);
	}
}
