// repeated sub problems.
// Time complexity = O(n^2)
// Space complexity = O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        int start =0;
        int end = 0;
        for(int i=1;i< n;i++) {
            for(int j= i;j>=0;j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i-j<=2 || dp[i-1][j+1]) {// the max string here i-j<=2 is 3 . which is like bab.
                        if(i-j> end -start) {
                            start = j;
                            end = i;
                        }

                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }

            }

        }
        return s.substring(start, end+1);
    }
}