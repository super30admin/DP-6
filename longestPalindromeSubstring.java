// Time Complexity : O(N^2)
// Space Complexity : O(N^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class longestPalindromeSubstring {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = "";
        for(int k = 0; k < dp.length; k++){
            for(int i = 0, j = k; j < dp.length; i++, j++){
                if(k == 0)
                    dp[i][j] = true;
                else if(k == 1){
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                }else{
                    if(dp[i+1][j-1] == true && s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                }
                if(dp[i][j] == true)
                    ans = s.substring(i, j+1);
            }
        }
        return ans;
    }
}
