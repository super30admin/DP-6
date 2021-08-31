// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int nthUglyNumber(int n) {
        if(n == 1) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        int p2 = 0,p3 = 0, p5 = 0;
        int n2 = 2,n3 = 3, n5 = 5;
        for(int i = 1 ; i <= n ; i++){
            int min = Math.min(Math.min(n2*dp[p2],n3*dp[p3]),n5*dp[p5]);
            dp[i] = min;
            if(min == n2*dp[p2]) p2++;
            if(min == n3*dp[p3]) p3++;
            if(min == n5*dp[p5]) p5++;  
        }
        return dp[n-1];
        
    }
}