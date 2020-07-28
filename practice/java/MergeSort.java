import java.util.Arrays;

class MergeSort {
	public static void main(String[] args) {
		int[] arr = {8, 9, 1, 10, 2};
		MergeSort o = new MergeSort();
		o.mergeSort(arr, 0, 4);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l == r) {
			return;
		}

		int m = ((l + r) / 2) + 1;
		mergeSort(arr, l, m - 1);
		mergeSort(arr, m, r);
		merge(arr, l, m, r);
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int[] temp = new int[r - l + 1];

		int leftp = l;
		int rightp = m;
		int k = 0;

		for (int i = 0; i < r - l + 1; i++) {
			if (leftp == m) {
				temp[k++] = arr[rightp];
				rightp++;
			} else if (rightp > r) {
				temp[k++] = arr[leftp];
				leftp++;
			} else {
				if (arr[leftp] < arr[rightp]) {
					temp[k++] = arr[leftp];
					leftp++;
				} else {
					temp[k++] = arr[rightp];
					rightp++;
				}
			}
		}

		k = 0;
		for (int i = l; i <= r; i++) {
			arr[i] = temp[k++];
		}
	}
}