// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j + 1 <= 2 || dp[i-1][j+1]){
                        dp[i][j] = true;
                        if(i - j + 1 > max){
                            max = i - j + 1;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}