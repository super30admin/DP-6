public class problem2 {
int max;
int start, end;

// using expanding window technique
    // Space Compexity: O(1)
    //Time Compexity: O(n^2)
    public String longestPalindrome(String s) {
        int n= s.length();
        this.max=0;
        for (int i=0;i<n;i++)
        {
            extendAround(s,i,i);
            if (i<n-1 && s.charAt(i)==s.charAt(i+1)) {
                extendAround(s, i, i + 1);
            }
        }
        return s.substring(start,end+1);
    }
    public void extendAround(String s, int left, int right)
    {
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        left++;
        right--;
        if (max<right-left)
        {
            start = left;
            end = right;
            max=right-left;
        }
    }

    // Using DP problem
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String longestPalindrome1(String s) {
        int n= s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) ) {

                    if (i-j<=1 || dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                        if (end-start <i-j)
                        {
                            start= j;
                            end= i;
                        }
                    }
                    else {
                        dp[i][j] = false;
                    }

                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start,end+1);
    }
}
