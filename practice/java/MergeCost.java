import java.util.Arrays;

class MergeCost {
	public static void main(String[] args) {
		int[] arr = {5, 1, 1, 5};
		System.out.println(findCost(arr, 0));
	}

	public static int findNext(int[] arr, int pos) {
		for (int i = pos + 1; i < arr.length; i++)
			if (arr[i] != -1)
				return i;

		return -1;
	}

	public static int realLen(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1)
				count++;
		}

		return count;
	}

	private static int findCost(int[] arr, int cost) {
		if (realLen(arr) == 1) {
			System.out.println("Returning:" + Arrays.toString(arr));
			return cost;	
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == -1)
				continue;

			System.out.println(Arrays.toString(arr));
			System.out.println("Cost: " + cost);
			System.out.println("Current pos: " + i);

			int nextEl = findNext(arr, i);
			if (nextEl == -1)
				break;

			int sum = arr[i] + arr[nextEl];
			int copy1 = arr[i];
			int copy2 = arr[nextEl];
			

			// Change array
			arr[i] = sum;
			arr[nextEl] = -1;
			int currCost = cost + sum;
			int subCost = findCost(arr, currCost);
			if (min > subCost) {
				min = subCost;
			}

			// Revert array
			arr[nextEl] = copy2;
			arr[i] = copy1;
		}

		return min;
	}
}
