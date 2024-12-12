class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        int start=0;
        int max=Integer.MIN_VALUE;
        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j=i+len-1;
                if(i==j)dp[i][j]=true;
                else if(len==2)dp[i][j]=s.charAt(i)==s.charAt(j);
                else if(len>2){
                    dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1>max){
                    start=i;
                    max=j-i+1;
                }
            }
        }
        return s.substring(start,start+max);
    }
}
