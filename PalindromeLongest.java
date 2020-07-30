// Time Complexity : 
/*                      Approach 1 : Using DP: O(n^2) where n is the length of the string
                        Approach 2: Using Two Pointers: O(n^2) where n is the length of the string
// Space Complexity :
/*                      Approach 1 : Using DP: O(n^2) for dp matrix
                        Approach 2: Using Two Pointers: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Understanding the two pointer approach for odd and even length.
/* Your code here along with comments explaining your approach: In approach 1, wwe create dp matrix of n^2 and we iterate over the string. For each
character, we introduce a j pointer there and move backwards to check if the subproblem is a palindrome or not. If the length < 2, or if the anti
diagonal is true, it is a palindrome else not.  For each character, j moves backwards till it goes lesser than 0. For approach 2, we have two pointers
at each character of the string. For each character, we check if we can have palindromes at odd and even length. If odd length, both the pointers
that are supposed to move forward and backward to check equal characters are at the same ith position else in th even length , j is placed to the next of
ith position. If the characters are not equal at any instant, palindrome breaks and we note the max length palindrome.
*/
// APPROACH 1 : USING DP
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int start  = 0, end = 0, max = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < dp.length; i++){
            int j  = i;                                                                                     // Start from ith position
            while(j >= 0){
                if(s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[i-1][j+1])){                        // If characters are equal and length < 2 or anti diagonal is true
                      dp[i][j] =true;
                        if(i - j > max){                                                            // Note the max length palindrome got till now
                            max = i-j;
                            start = j;                                                      // Start and end index of the substring
                            end = i;
                        }
                }   
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start ; i <= end; i++)
            sb.append(s.charAt(i));                                                                                 // Append the substring
        return sb.toString();                                                                           // Return the substring
    }
}

// APPROACH 2 : USING TWO POINTERS
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int start  = 0, end = 0, j = 0, k = 0,max= 0;
        for(int i = 0; i < s.length(); i++){                                                        // For each ith character
            for(int r = 0; r < 2; r++){                                                                 // Length can be even or odd
                if(r % 2 == 0){
                     j = i+1;                                                           // Even length  => Place j pointer next to ith position
                } else {
                    j = i;                                                              // Odd length => Place i and j on same position
                }
               k = i;
               while(k >= 0 && j < s.length()){                                             // While within the bounds
                   if(s.charAt(k) == s.charAt(j)){                                          // If the characters are equal
                       if(j - k > max){
                           max = j - k;                                                                 // Keep the max length substring
                           start = k;
                           end = j;
                       }
                   } else {break;}                                                                  // Unequal characters, break
                   k--;
                   j++;
               }
            }
    }
        return s.substring(start, end+1);                                                           // Return the substring from start to end
    }
}