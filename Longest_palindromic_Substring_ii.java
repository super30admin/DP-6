//TC - O(N^2)
//SC - O(1)
class Solution3 {
	int start;
	int max;

	public String longestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			// odd case
			extendPalindrome(s, i, i);
			// even case
			if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
				extendPalindrome(s, i, i + 1);
			}
		}
		return s.substring(start, start + max);
	}

	private void extendPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if (right - left - 1 > max) {
			max = right - left - 1;
			start = left + 1;
		}
	}
}
