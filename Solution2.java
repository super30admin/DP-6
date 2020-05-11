// Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)

// Optimised 
// Time - O(n^2)
// Space - O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int maxlen = 0;
        String longestString = "";
        
        //length 1
        for (int i = 0; i < len; i++){
            dp[i][i] = true;
            maxlen = 1;
            longestString = s.substring(i,i+1);
        }
        
        //Length 2
        for (int i = 0; i < len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                if(maxlen < 2){
                    maxlen = 2;
                    longestString = s.substring(i,i+2);
                 }
            }
        }
        
         //Length 3 and above
        for (int strlen = 3; strlen <= len; strlen++){
            for(int startIdx = 0; startIdx < len - strlen + 1; startIdx++){
                int endIdx = startIdx + strlen - 1;
                
                if(dp[startIdx+1][endIdx-1] && s.charAt(startIdx) == s.charAt(endIdx)){
                    dp[startIdx][endIdx] = true;
                    if(maxlen < endIdx - startIdx + 1){
                        maxlen = endIdx - startIdx + 1;
                        longestString = s.substring(startIdx,endIdx+1);
                    }
                }
            }
        }
        return longestString;
    }
}




// Optimised -  no extra space
// Time - O(n^2)
// Space - O(1)
class Solution {  
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 2){
            return s;
        }
        // expand from the middle most character in case of odd string
        // expand from the middle two characters in case of even string
        
        Wrapper wrapper = new Wrapper();
        for(int mid = 0; mid < s.length(); mid++){
            //for odd string
            expand(s, mid, mid, wrapper);
            //for even string
            expand(s, mid, mid + 1, wrapper);
        }
        
       
        
        return s.substring(wrapper.start,wrapper.start + wrapper.maxlen );
    }
    
    private void expand(String s, int left, int right, Wrapper wrapper){
        int n = s.length();
        while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            
        }
        left++;
        right--;
        
        if(wrapper.maxlen < right - left + 1){
            wrapper.maxlen = right - left + 1;
            wrapper.start = left;
        }
    }
}




class Wrapper{
    int maxlen;
    int start;
    
    Wrapper(){
        maxlen = Integer.MIN_VALUE;
    }
}