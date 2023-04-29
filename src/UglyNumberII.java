//Time Complexity : O(N)
//Space Complexity : O(N)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Initially 1 will be the ugly number so put it in dp[1]. Then for next indices
 * to fill, multiply 1 with 2, 3 and 5. Take min of them and put it ith index
 * then update the index of 2,3 or 5 which was used to get this number. Finally
 * return dp[n].
 *
 */
public class UglyNumberII {
	class Solution {
	    public int nthUglyNumber(int n) {
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = 1;
	        int p2 = 1, p3 = 1, p5 = 1;
	        for(int i=2;i<=n;i++) {
	            int next2 = dp[p2] * 2;
	            int next3 = dp[p3] * 3;
	            int next5 = dp[p5] * 5;
	            int ans = Math.min(next2, Math.min(next3, next5));
	            dp[i] = ans;
	            if(ans == next2) p2++;
	            if(ans == next3) p3++;
	            if(ans == next5) p5++;
	        }
	        return dp[n];
	    }
	}
