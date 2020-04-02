// Time complexity is O(N^2)
// Space complexity is O(1)
// This solution is submitted on leetcode

public class BigN168LongestSubStringPanlindromeTwoPointer {
	class Solution {
		int start;
		int maxLength;

		public String longestPalindrome(String s) {
			// edge case
			int n = s.length();
			if (n < 2)
				return s;
			for (int i = 0; i < n; i++) {
				extendPalindrome(s, i, i);
				extendPalindrome(s, i, i + 1);
			}
			return s.substring(start, start + maxLength);
		}

		private void extendPalindrome(String s, int left, int right) {
			while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			}
			if (right - (left + 1) > maxLength) {
				start = left + 1;
				maxLength = right - (left + 1);
			}
		}
	}
}