//time and space - O(n^2)
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.isEmpty() || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        String result = "";

        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i-j-1 <= 1 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    String substring = s.substring(j, i+1);
                    if(substring.length() > max) {

                        max = substring.length();
                        result = substring;
                    }
                }
            }
        }

        return result;
    }
}