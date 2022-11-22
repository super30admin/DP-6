class Solution {
    //tc-o(n^2) sc-o(n^2)
    int start=0, end = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
 
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if((s.charAt(i) == s.charAt(j))&&
                ((i-j<2)|| dp[i-1][j+1]))
                {
                dp[i][j] = true;
                if(i-j> end-start)
                {
                    end=i;
                    start=j;
                }
                }

            }
        }
        return s.substring(start,end+1);
    }
}