// DP Soltuion
// TC: O(n2)
// SC: O(n2)
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for(int i=0;i<n;i++) {
            for(int j=i;j>=0;j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i - j <= 2 || dp[i-1][j+1]) {
                        dp[i][j] = true;
                        if(i - j > end - start) {
                            start = j;
                            end = i;
                        }
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}



// Two pointer solution
// TC: O(n2)
// SC: O(1)
class Solution {
    int start = 0;
    int end = 0;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++) {
            // odd length palindrome
            extendAroundCenter(s,i,i);
            if(i<n-1 && s.charAt(i) == s.charAt(i+1)) {
                //even length palindrome
                extendAroundCenter(s,i,i+1);
            }
        }
        return s.substring(start,end+1);
    }

    private void extendAroundCenter(String s, int l, int r) {
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if(r-l > end-start) {
            start = l;
            end = r;
        } 
    }
}