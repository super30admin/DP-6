// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// same time complexity, better space!
class Solution {
    int n;
    int max; int start; int end;
    public String longestPalindrome(String s) {
        // null 
        if(s == null || s.length() == 0) return s;
        n = s.length();
        
        for(int i=0; i<n; i++){
            extendAroundCenter(s, i, i); // odd length
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){ // even length
                extendAroundCenter(s, i, i+1);
            }
        }
        return s.substring(start, end+1);
    }
    private void extendAroundCenter(String s, int l, int r){
        while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
            l--; r++;
        }
        // either out of bounds or mismatch!
        l++; r--;
        if((r-l) > (end-start)){
            start = l; end = r;
        }
    }
}

// ***************************************************************

// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// DP not optimal!
class Solution {
    public String longestPalindrome(String s) {
        // null 
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        int start = 0; int end = 0;
        boolean[][] dp = new boolean[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<=i; j++){
                if(s.charAt(i) == s.charAt(j) && ( (i-j < 2) || dp[i-1][j+1]) ){
                    dp[i][j] = true;
                    if( (i-j) > (end-start) ){
                        start = j;
                        end = i;
                    }
                }
                
            }
        }
        return s.substring(start, end+1);
    }
}
