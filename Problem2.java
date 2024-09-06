/*
    LC - 5. Longest Palindromic Substring
    TC - O(n2)
    SC - O(1) - optimized space compare to DP solution.
*/

class Solution {
    int max, start, end;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        for(int i=0; i<s.length(); i++) {
            expandAroundCenter(s, i, i);
            if(i < s.length() - 1) {
                expandAroundCenter(s, i, i+1);
            }
        }
        return s.substring(start, end+1);
    }
    private void expandAroundCenter(String s, int l, int r) {
        while((l >=0 && r < s.length()) && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        l++;
        r--;
        if(max < r - l + 1) {
            max = r - l + 1;
            start = l;
            end = r;
        }
    }
}

/*
    TC - O(n2)
    SC - O(n2)
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp= new boolean[n][n];
        int max= 0;
        int start = 0;
        int end = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(s.charAt(i) == s.charAt(j) && ((i-j-1 < 2) || (dp[i-1][j+1]))) {
                    dp[i][j] = true;
                }
                if(dp[i][j] == true) {
                    if(i - j + 1 > max) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}