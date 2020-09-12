// Time Complexity - O(n) can be O(1) for both N is constant.
// Space Complexity- O(n)

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int n2 = 2;
        int n3 = 3;
        int n5 = 5;
        for(int i=1;i< n;i++){
            dp[i] = Math.min(n2,Math.min(n3,n5));
            if(dp[i] == n2){
                p2++;
                n2 = dp[p2] * 2;
            }
            if(dp[i] == n3){
                p3++;
                n3 = dp[p3] * 3;
            }
            if(dp[i] == n5){
                p5++;
                n5 = dp[p5] * 5;
            }
        }
        return dp[n-1];
    }
}