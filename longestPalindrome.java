// Problem 5. Longest Palindromic Substring
// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            boolean right = false;
            for (int j = i; j >= 0; j--) {
                boolean temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j <= 2 || right) {
                        dp[j] = true;
                        if (i - j > end - start) {
                            start = j;
                            end = i;
                        }
                    } else {
                        dp[j] = false;
                    }
                } else {
                    dp[j] = false;
                }
                right = temp;
            }
        }
        return s.substring(start, end + 1);
    }
}
