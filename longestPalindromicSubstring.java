// Time Complexity : O(n^2) where n is the length of the string s
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// taking all possible centers for a palindrome of odd and even length
// then expanding around it till the substring remains a palindrome
// keep track of start and maxLen and in the end output the max subsstring

class longestPalindromicSubstring {
    int start, maxLen;
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        for (int i = 0; i < n - 1; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);  
        }
        return s.substring(start, start + maxLen);
    }
    private void expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLen) {
            start = i + 1;
            maxLen = j - i - 1;
        }
    }
}