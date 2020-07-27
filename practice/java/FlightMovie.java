import java.util.Arrays;

class FLightMovie {
	public static void main(String[] args) {
		int movieLengths = {27, 1, 10, 39, 12, 52, 32, 67, 76};
		int flightLength = 77;

		for (int i = 0; i < movieLengths.length - 1; i++) {
			for (int j = 0; j < movieLengths.length - 1 - i; j++) {
				if (movieLengths[j] > movieLengths[j + 1]) {
					int temp = movieLengths[j];
					movieLengths[j] = movieLengths[j + 1];
					movieLengths[j + 1] = temp;
				}
			}
		}

		int leftPointer = 0;
		int rightPointer = movieLengths.length;

		leftCandidate = movieLengths[leftPointer];
		rightCandidate = movieLengths[rightPointer];
		int max = leftCandidate + rightCandidate;
		while (leftPointer != rightPointer) {
			int sum = movieLengths[leftPointer] + movieLengths[rightPointer];
			if (sum > flightLength) {
				rightPointer--;
				continue;
			}

			if (max < sum) {
				leftCandidate = movieLengths[leftPointer];
				rightCandidate = movieLengths[rightPointer];
			}
			leftPointer++;
		}
	}
}
