import java.util.HashMap;

class DistinctSubstring {
	public static void main(String[] args) {
		String str = "aabab";
		int K = 3;

		int answer = 0;

		int windowLeft = 0;
		int windowRight = windowLeft + K - 1;

		HashMap<Character, Integer> count = new HashMap<>();

		// Initial check
		for (int i = windowLeft; i <= windowRight; i++) {
			char c = str.charAt(i);

			if (count.get(c) == null) {
				count.put(c, 1);
			} else {
				count.put(c, count.get(c) + 1);
			}
		}	

		if (count.size() == K) {
			answer++;
		}

		windowLeft++;
		windowRight++;

		while (windowRight < str.length()) {
			char c = str.charAt(windowRight);

			// Add new character
			if (count.get(c) == null) {
				count.put(c, 1);
			} else {
				count.put(c, count.get(c) + 1);
			}

			// Decrease or remove first character
			count.put(str.charAt(windowLeft - 1), count.get(str.charAt(windowLeft - 1)) - 1);
			if (count.get(str.charAt(windowLeft - 1)) == 0) {
				count.remove(str.charAt(windowLeft - 1));
			}

			// Check size
			if (count.size() == K) {
				answer++;
			}

			windowLeft++;
			windowRight++;
		}

		System.out.println(answer);	
	}
}
