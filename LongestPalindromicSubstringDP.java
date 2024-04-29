// ## Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

// DP
// Time: O(N*N)
// Space: O(N*N)
// Where N is the length of input string
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<=1){
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;

        int start=0;
        int end=0;

        // i represents start of substring
        // j represents end of substring
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j){
                    dp[i][j] = true;
                }else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = (j==i+1) || dp[i+1][j-1];
                }

                if(dp[i][j] && (j-i)>(end-start)){
                    // if new palindrome longer then update result
                    start=i;
                    end=j;
                }
            }
        }

        return s.substring(start, end+1);
    }
}