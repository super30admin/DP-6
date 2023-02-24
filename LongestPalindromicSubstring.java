//https://leetcode.com/problems/longest-palindromic-substring
//TC : O(n^2)
//SC : O(n^2)

//dp [][] solution
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i =0; i < n ; i++){
            for(int j=0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                     if(i-j<=2 || dp[i-1][j+1]){
                         dp[i][j] = true;
                         if(i-j+1 > max){
                             max = i-j+1;
                             start = j;
                             end = i;
                         }
                     }
                }
                
            }
        }
        return s.substring(start,end+1);
    }
}

//dp [] solution
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        boolean[] dp = new boolean[n];
        for(int i =0; i < n ; i++){
            for(int j=0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j)){
                     if(i-j<=2 || dp[j+1]){
                         dp[j] = true;
                         if(i-j+1 > max){
                             max = i-j+1;
                             start = j;
                             end = i;
                         }
                     }else{
                         dp[j] = false;
                     }
                }else{
                         dp[j] = false;
                     }
                
            }
        }
        return s.substring(start,end+1);
    }
}
