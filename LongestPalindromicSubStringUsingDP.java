// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes

public class LongestPalindromicSubStringUsingDP {
    public String longestPalindrome(String s) {
        int start=0,end=0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i-j <= 1 || dp[i-1][j+1])
                    {
                        dp[i][j] = true;
                        if(i-j > end - start)
                        {
                            start = j;
                            end = i;
                        }
                    }
                    else{
                        dp[i][j] = false;
                    }
                }
                else{
                    dp[i][j] = false;
                }
            }
        }

        return s.substring(start,end+1);
    }
}
