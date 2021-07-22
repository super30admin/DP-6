public class LongestPalindromicSubString {

    // TC:O(N^2) Two pointers, Comparing each character with rest of the substring.
    // SC:O(N^2) DP array.

    // Start from last character and one pointer compares each charac if it matches
    // it is a sub problemd get it from the dp.

    public String longestPalindrome(String s) {

        if (s.length() <= 1)
            return s;
        int n = s.length();
        int length = 1;
        int startIndex = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int difference = j - i;
                    if (difference == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (difference + 1 > length) {
                            length = difference + 1;
                            startIndex = i;
                        }
                    }

                }
            }
        }
        return s.substring(startIndex, startIndex + length);
    }

    public static void main(String[] args) {
        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
        longestPalindromicSubString.longestPalindrome("aacabdkacaa");
    }
}
