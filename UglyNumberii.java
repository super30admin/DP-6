// Time Complexity : O(V(V+E))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// DP
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        
        int p2 = 0, p3=0, p5=0;
        int n2 = 2, n3=3, n5=5;
        
        dp[0] = 1;
        
        for(int i=1; i<n; i++){
            int min = Math.min(n2, Math.min(n3, n5));
            dp[i] = min;
            
            if(min== n2){
                p2++;
                n2 = 2 * dp[p2];
            }
            if(min== n3){
                p3++;
                n3 = 3 * dp[p3];
            }
            if(min== n5){
                p5++;
                n5 = 5 * dp[p5];
            } 
        }
        
        return dp[n-1];
    }
}