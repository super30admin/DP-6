class Solution {
    // babad and babab

    // Expand Around Center method. Palin string can be in odd or even length. Like aba or abba.
    // for aba we have to start from middle char b and then expand in sides. So a and a are compared.
    // for abba, we have to start from center b b and then expand to compare a and a. Hence for each char, find the odd and even length palin. Then find the4 greatest among them.
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); ++i) {
            int oddLen = find(s, i, i); // odd len
            int evenLen = find(s, i, i + 1); // even len
            int len = Math.max(oddLen, evenLen);

            if (len >= end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    private int find(String s , int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            --l;
            ++r;
        }

        return r - l - 1;
    }

    // DP solution
    public String longestPalindromeDFS(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        int start = 0;
        int maxLen = 1;
        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i < n - len + 1; ++i) {
                int j = i + len -1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && len > maxLen) {
                    maxLen = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
        
    }
}