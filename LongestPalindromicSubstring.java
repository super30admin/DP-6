// Time Complexity : O(n*n) where n = length of string
// Space Complexity : O(1) where n = length of string
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//5. Longest Palindromic Substring (Medium) - https://leetcode.com/problems/longest-palindromic-substring/
// Time Complexity : O(n*n) where n = length of string
// Space Complexity : O(n) where n = length of string
//class Solution {
//
//	int start, end;
//
//	public String longestPalindrome(String s) {
//		if (s == null || s.length() == 0)
//			return s;
//
//		int n = s.length();
//		// boolean[][] dp = new boolean[n][n]; // O(n*n)
//		boolean[] dp = new boolean[n]; // O(n)
//		
//		for (int i = 0; i < n; i++) { // O(n)
//			for (int j = 0; j <= i; j++) { // O(n)
//				if (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[j + 1])) {
//				// if (s.charAt(i) == s.charAt(j) && ((i - j) < 2 || dp[i - 1][j + 1])) {
//					// dp[i][j] = true;
//					dp[j] = true;
//
//					if (i - j > end - start) {
//						start = j;
//						end = i;
//					}
//				} else {
//					dp[j] = false;
//				}
//			}
//		}
//
//		return s.substring(start, end + 1);
//	}
//}

// Time Complexity : O(n*n) where n = length of string
// Space Complexity : O(1) where n = length of string
class Solution {

	int start, end;

	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;

		int n = s.length();

		for (int i = 0; i < n; i++) { // O(n)
			extendAroundCenter(s, i, i); // check for odd length palindrome, O(n)

			if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
				extendAroundCenter(s, i, i + 1); // check for even length palindrome, O(n)
			}
		}

		return s.substring(start, end + 1);
	}

	private void extendAroundCenter(String s, int l, int r) {
		while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}

		l++;
		r--;

		if (r - l > end - start) {
			start = l;
			end = r;
		}
	}
}