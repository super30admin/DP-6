// Time Complexity : O(n^2)
// Space Complexity : O(n^2) 
// Did this code successfully run on Leetcode : yes

// Your code here along with comments explaining your approach
// build a dp array which stores dp[i][j] == true if S[i:j] is a palindrome, can reuse results by dp[i][j] = true if s[i]==s[j] && dp[i+1][j-1]

class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1)
            return s;
        
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int k = 0;
        int maxLength = 1;
        int startIdx = 0;
        
        while(k<n){
            dp[k][k] = true;
            k++;
        }
        
        k=0;
        while(k+1<n){
            if(s.charAt(k)==s.charAt(k+1)){
                dp[k][k+1] = true;
                maxLength = 2;
                startIdx = k;
            }                    
            k++;
        }
        
        for(int l=3; l<=n; l++){
            int i = 0, j = i+l-1;
            
            while(j<n){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j]){
                        maxLength = l;
                        startIdx = i;                            
                    }
                } 
                i++;
                j++;
            }
        }
        
        return s.substring(startIdx, startIdx+maxLength);
    }
}