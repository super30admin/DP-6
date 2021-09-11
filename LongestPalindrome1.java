// Time Complexity : O(n * n)
// Space Complexity : O(n * n)

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty())
            return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1] == true)){
                    dp[i][j] = true;
                    if(i - j + 1 > max){
                        start = j;
                        end = i;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}