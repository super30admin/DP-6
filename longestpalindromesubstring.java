/*
Time Complexity: O(N*N)
Space Complexity: O(1)
*/
class Solution {
    public String longestPalindrome(String s) {
 
        Boolean dp[][] = new Boolean[s.length()][s.length()];
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, dp, i, j)) {
                    String subS = s.substring(i, j + 1);
                    max = subS.length() > max.length() ? subS : max;
                }
            }
        }
        return max;
    }

    private Boolean isPalindrome(String s, Boolean[][] dp, int start, int end) {
        if (start > end)
            return null;

        if (dp[start][end] != null)
            return dp[start][end];

        Boolean isPalindrome = isPalindrome(s, dp, start + 1, end - 1);
        if (isPalindrome == null) {
            isPalindrome = s.charAt(start) == s.charAt(end) ? true : false;
        }

        isPalindrome = isPalindrome ? s.charAt(start) == s.charAt(end) : false;

        dp[start][end] = isPalindrome;
        return isPalindrome;
    }
}