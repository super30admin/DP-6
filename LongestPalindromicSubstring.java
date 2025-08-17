// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : create a 2d matrix of size n*n where n=string length. For each character, check if a string is palindrome is ending
/// at that index, by iterating j from i to 0, to check if s.substring(j,i+1) is palindrome, we just need to check if character at
/// i and j is same and if substring i-1 -> j+1 is palindrome or not, which we have already solved in dp[i-1][j+1]
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int start = 0, end = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(i) == s.charAt(j)){
                    if(i-j>1){
                        dp[i][j] = dp[i-1][j+1];
                    }
                    else{
                        dp[i][j] = true;
                    }
                    if(dp[i][j] && end-start<i-j){
                        end = i;
                        start = j;
                    }
                }
                else{
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start, end+1);
    }
}