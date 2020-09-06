//TC - O(N^2)
//SC - O(N^2)
class Solution2 {
	public String longestPalindrome(String s) {
		// edge
		if (s == null || s.length() < 2)
			return s;
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		int start = 0;
		int end = 0;
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
					dp[i][j] = true;
					if (end - start < i - j) {
						start = j;
						end = i;
					}
				}
			}
		}
		return s.substring(start, end + 1);
	}
}