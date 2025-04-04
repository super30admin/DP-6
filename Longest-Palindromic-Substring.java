   
## Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

Time Complexity = O(n2)
Space Complexity = O(n2)
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max =1;
        int start =0;
        int end=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                // if(s.charAt(i)==s.charAt(j)){
                //     int length = i-j-1;
                //     if(len>=2){
                //         dp[i][j] = dp[i-1][j+1];
                //     }
                //     max=i-j+1;
                //     start = i;
                //     end = j;
                // }
                if((s.charAt(i)==s.charAt(j)) && ((i-j-1 < 2) || (dp[i-1][j+1] == true))){
                    dp[i][j] = true;
                }
                if(dp[i][j] == true){
                    if(i-j+1 > max){
                        max = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        } 
        return s.substring(start,end+1);
    }
}


//Non DP based Solution
Time Complexity : O(n2)
Space Complexity : O(1)

