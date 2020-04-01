// Dp Solution
// Time Complexity - O(n^2)
// Space Complexity - O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2)  return s;
        int n = s.length();
        int start=0;
        int end=0;
        boolean [][] dp = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=i; j>=0; j--){
                if(s.charAt(i) == s.charAt(j) && ((i-j) <= 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                    if(i-j > end-start){
                        start= j;
                        end = i;
                    }
                }    
            }
        }
        return s.substring(start,end+1);
    }
}


// Using midpoint
// Time Complexity - O(n^2)
// Space Complexity - O(1)
// This solution worked on Leetcode
class Solution {
    int maxlen;
    int start;
    public String longestPalindrome(String s) {
        if(s.length() < 2)  return s;
        int n = s.length();
        //maxlen =0;
        //start=0;
        for(int i=0;i< n; i++){
            extendpalindrome(s,i,i);
            extendpalindrome(s,i,i+1);
        }
        return s.substring(start,start+maxlen);
    }
    
    private void extendpalindrome(String s,int left, int right){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        if(right- (left + 1) > maxlen){
            start = left+1; 
            maxlen = right-( left + 1);
        }     
    }
}

