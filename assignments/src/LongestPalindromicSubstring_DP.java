// Approach: Bottom up DP - tabulation
// Time: O(n^2)
// Space: O(n^2)

class LongestPalindromicSubstring_DP {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<=i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i-j <= 2 || dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        if (i-j+1 > max) {
                            max = i-j + 1;
                            start = j;
                            end = i;
                            if (max == n) return s.substring(start, end+1);
                        }
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}