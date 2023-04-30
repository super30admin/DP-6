/*
Longest Palindromic Substring
approach: use dp and check for repeated sub-problems
space optimized: we can extend strings from each character to left and right
time: O(n^2)
space: O(n^2) O(n) O(1)
 */
public class Problem2 {
/*    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return s;
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (s.charAt(i)==s.charAt(j) && ((i-j)<2 || dp[i-1][j+1])) {
                    dp[i][j] = true;
                    if (end-start<j-i) {
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return res;
    }*/
    int start = 0, end = 0;
    public String longestPalindromeOptimized(String s) {
        int n = s.length();

        for (int i=0;i<s.length();i++) {
            extendAroundCentre(s, i, i);
            if (i<n-1) extendAroundCentre(s, i, i+1);
        }

        return s.substring(start, end+1);
    }

    private void extendAroundCentre(String s, int l, int r) {

        while (l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)) {
            l--;
            r++;
        }
        l++;
        r--;
        if (end-start < r-l)
        {
            start = l;end = r;
        }
    }

    public static void main(String []args) {
        Problem2 problem2 = new Problem2();
        problem2.longestPalindromeOptimized("babad");
    }
}
