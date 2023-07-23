// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
public:
    int nthUglyNumber(int n) {
        int p2 = 0,p3 = 0,p5 = 0;
        vector<int>dp(n);
        dp[0] = 1;
        for(int i = 1; i<n;i++)
        {
            int two = dp[p2] * 2;
            int three = dp[p3] *3;
            int five = dp[p5] * 5;

            dp[i] = min({two,three,five});
            if(two == dp[i]) p2++;
            if(three == dp[i]) p3++;
            if(five == dp[i]) p5++;
        }
        return dp[n-1];
    }
};