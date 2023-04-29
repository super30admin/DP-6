//Time Complexity : O(N*N)
//Space Complexity : O(N*N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * First take dp matrix of size n. Then fill diagonals with true. Then iterate
 * till last but one row and check i and i+1 chars if equal, mark the dp[i][i+1]
 * as true. In next step take length from 3 to n and check if 1st and last char
 * matches, if so, then check remaining chars match by checking i+1, j-1 th
 * index of dp matrix. update max with k and note start index. Finally return
 * start + max substring.
 *
 */
class Solution {
	public String longestPalindrome(String s) {
		int n = s.length();
		int max = 0, start = 0;
		boolean[][] dp = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			max = 1;
			start = i;
		}

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = true;
				max = 2;
				start = i;
			}
		}

		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					if (k > max) {
						max = k;
						start = i;
					}
				}
			}
		}

		return s.substring(start, start + max);
	}
}
