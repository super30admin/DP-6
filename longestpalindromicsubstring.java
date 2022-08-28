//TC,SC - O(m*n)
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i - j < 2 || dp[i - 1][j + 1]){
                        dp[i][j] = true;
                        if(end - start < i - j){
                            end = i;
                            start = j;
                        }
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
