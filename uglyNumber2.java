// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class uglyNumber2 {
    public int nthUglyNumber(int n) {
        int primeFactor2 = 0, primeFactor3 = 0, primeFactor5 = 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            dp[i] = Math.min(2*dp[primeFactor2],Math.min(3*dp[primeFactor3],dp[primeFactor5]*5));
            if(dp[i] == 2*dp[primeFactor2])
                primeFactor2++;
            if(dp[i] == 3*dp[primeFactor3])
                primeFactor3++;
            if(dp[i] == 5*dp[primeFactor5])
                primeFactor5++;
        }
        return dp[n-1];
    }
}
}
