// Time Complexity : O(n^2)
// Space Complexity : O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        
        // Store the value from start j till end i if that string is palindrome.
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        int max = 0;
        
        // Compute the substring and return the result
        int start = 0;
        int end = s.length();
        
        // Iterate through each cell
        for (int i = 0; i < s.length(); i++ ){
            
            for (int j = 0; j <= i ; j++){
                
                // Step 1 : If character at right most and character at left most same
                if (s.charAt(i) == s.charAt(j)){
                    
                    // i - j > 2 then only compute ( more than 2 characters , check the substring inside ( j+1 and i-1 : move j and move i ) 
                    if ( (i - j < 2) ||  dp[i - 1][j + 1]){
                        // Set the value as true
                        dp[i][j] =  true;
                        
                        // update max if it is larger
                        if ( i - j + 1 > max){
                            max = i - j  + 1;
                            start = j;
                            end = i;
                        }
                    }
                }
            }
        }
        
        // Largest substring
        return s.substring(start, end+1);
    }
}