// Time Complexity = O(n^2)
// Space Complexity = O(n^2)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// DP solution
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int max=0, start=0, end=0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i-j<=2) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i-1][j+1];
                    }
                }

                // check max value
                if (dp[i][j] && max < i-j+1) {
                    max = i-j+1;
                    start = j;
                    end = i;
                }
            }
        }

        return s.substring(start, end+1);
    }
}

// ----------------------------------------------------------------------------------------------------------------
// Time Complexity = O(n^2)
// Space Complexity = O(1)
// Sliding window/2 pointer solution

class Solution {
    int max, start, end;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();

        for (int i=0; i<n; i++) {
            expand(s, i, i);    // for odd length palindrome
            if (i<n-1 && s.charAt(i) == s.charAt(i+1)) {
                expand(s, i, i+1);    // for even length palindrome
            }
        }

        return s.substring(start, end+1);
    }

    private void expand(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if (max < right-left+1) {
            max = right-left+1;
            start = left;
            end = right;
        }
    }
}