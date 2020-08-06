class LCA {
	private static int lca(int[] tree, int node1, int node2, int cur) {
		if (cur >= tree.length)
			return -1;

		if (tree[cur] == node1)
			return node1;
		else if (tree[cur] == node2)
			return node2;

		int left = lca(tree, node1, node2, cur*2+1);
		int right = lca(tree, node1, node2, cur*2+2);

		if (left != -1 && right != -1)
			return tree[cur];

		return (left != -1) ? left : right;
	}

	public static void main(String[] args) {
		int[] tree = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(lca(tree, 2, 4, 0));
	}
}