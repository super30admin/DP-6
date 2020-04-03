//Time complexity is O(n)
//Space complexity is O(n)
//This solution is submitted on leetcode

public class BigN169UglyNumberUsingDPandPointers {
	class Solution {
		public int nthUglyNumber(int n) {
			// edge case
			if (n == 0)
				return 0;
			int p2 = 0, p3 = 0, p5 = 0;
			int n2 = 2, n3 = 3, n5 = 5;
			int[] dp = new int[n];
			dp[0] = 1;
			for (int i = 1; i < n; i++) {
				dp[i] = Math.min(n2, Math.min(n3, n5));
				if (dp[i] == n2) {
					p2++;
					n2 = 2 * dp[p2];
				}
				if (dp[i] == n3) {
					p3++;
					n3 = 3 * dp[p3];
				}
				if (dp[i] == n5) {
					p5++;
					n5 = 5 * dp[p5];
				}
			}
			return dp[n - 1];
		}
	}
}