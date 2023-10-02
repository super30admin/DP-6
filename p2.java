// Time Complexity :O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        //dp matrix
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if(ci == cj){
                    if(i-j < 2 || dp[i-1][j+1]){
                        if(end-start < i-j){
                            end = i;
                            start = j;
                        }
                        dp[i][j] = true;
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