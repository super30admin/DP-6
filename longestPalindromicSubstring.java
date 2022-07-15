/*
Problem: https://leetcode.com/problems/longest-palindromic-substring/
*/

// Approach 1: DP
// TC: O(n ^ 2)
// SC: O(n ^ 2)
class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0)
            return "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int maxLen = 0;
        int startIndex = 0;
        
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                // if i and j are the same, adding the middle element will still keep it a palindrome so j - 1 <= 2
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
                
                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    maxLen = j - i + 1;
                    startIndex = i;
                }
            }
        }
        
        return s.substring(startIndex, startIndex + maxLen);
    }
}

// Approach 2: 2 pointer
// TC: O(n ^ 2)
// SC: O(1)
class Solution {
    int maxLen;
    int startPos;
    int len;
    
    public String longestPalindrome(String s) {
        len = s.length();
        
        for(int i = 0; i < len; ++i) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i+1);
        }
        
        return s.substring(startPos, startPos+maxLen);
    }

    public void extendPalindrome(String s, int low, int high) {
        while(low >= 0 && high < len && s.charAt(low) == s.charAt(high)) {
            --low;
            ++high;
        }
        
        // low and high would have gone out of bounds, fix it.
        ++low;
        --high;
        
        if(high - low + 1 > maxLen) {
            maxLen = high - low + 1;
            startPos = low;
        }
    }
}