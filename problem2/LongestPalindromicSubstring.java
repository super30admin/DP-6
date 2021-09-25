// Time Complexity : O(n*n), n-> Length of string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class LongestPalindromicSubstring {
	int maxLen;
	int start;
	int end;

	/********************* Dynamic Programming *********************/
	// Time Complexity : O(n*n), n-> Length of string
	// Space Complexity : O(n*n)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No
	public String longestPalindromeDP(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int n = s.length();
		boolean[][] dp = new boolean[n][n];

		maxLen = 1;
		start = 0;
		end = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[i - 1][j + 1])) {
					dp[i][j] = true;
					if (i - j + 1 > maxLen) {
						maxLen = i - j + 1;
						start = j;
						end = i;
					}
				}
			}
		}
		
		return s.substring(start, end + 1);
	}

	/********************* Two Pointer *********************/
	// Time Complexity : O(n*n), n-> Length of string
	// Space Complexity : O(1)
	// Did this code successfully run on Leetcode : Yes
	// Any problem you faced while coding this : No

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int n = s.length();

		for (int i = 0; i < n; i++) {
			calculatePalindromicSubstring(s, n, i, i);
			if (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
				calculatePalindromicSubstring(s, n, i, i + 1);
			}
		}

		return s.substring(start, end + 1);
	}

	private void calculatePalindromicSubstring(String s, int n, int left, int right) {
		while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		left++;
		right--;

		if (right - left > maxLen) {
			maxLen = right - left;
			start = left;
			end = right;
		}
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring obj = new LongestPalindromicSubstring();

		String s = "babad";

		System.out.println("Longest Palindromic Substring: " + obj.longestPalindrome(s));
	}

}
