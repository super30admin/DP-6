//OPtimization 

//TC : O(N^2)
//SC : O(1)

class Solution {
    int max, start, end;
    public String longestPalindrome(String s) {
        if(s == null)  return "";
        int n = s.length();
            
        for(int i = 0; i< s.length(); i++){
            if(end - start + 1 == s.length())   return s;
            
            expandCharacters(s, i, i); // odd length string
            if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)){
                expandCharacters(s, i, i+1); //Even length string
            }
        }                
        return s.substring(start, end + 1);
    }
    public void expandCharacters(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
            l--; r++;
        }
        
        int left = l + 1;
        int right = r - 1;
        
        int currLen = right - left + 1;
        if(currLen > max){
            max = currLen;
            start = left;
            end = right;
        }
    }
}

/*


//Brute-Force will be in O(N^3)


//TC : O(N^2)
//SC : O(N^2)
//DP Solution


class Solution {
    public String longestPalindrome(String s) {
        if(s == null)  return "";
        int n = s.length();
    
        boolean[][] dp = new boolean[n][n];
        
        int max = 1;
        int start = 0, end = 0;
        for(int i = 1; i< n; i++){
            for(int j = 0; j <= i ; j++){
                //If char matches and length of substring is EITHER LESS THAN 2 or substring is palindrome dp[i-1][j+1] true
                if(s.charAt(i) == s.charAt(j) && ( (i - j < 2) || dp[i-1][j+1] ) ){
                    dp[i][j] = true;
                    int len = i - j  + 1;
                    if(len > max){ // Update maxLen and indices of substring    
                        max = len;
                        start = j;
                        end = i;
                    }
                }
            }
        }
    
        return s.substring(start, end + 1);

    }
}

*/
