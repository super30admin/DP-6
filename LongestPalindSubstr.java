class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() < 1) return "";
        
        int n= s.length();
        int dp[][]= new int[n][n];
        
        int maxLength=0;
        String ans=""; 
        char [] charArr= s.toCharArray();
        for(int diff=0; diff<n; diff++){
            for(int i=0, j=i+diff; j<n; i++,j++){
                if(i==j)
                    dp[i][j]=1;
                else if(diff==1){
                    if(charArr[i]==charArr[j])
                        dp[i][j]= 2;
                    else dp[i][j]= 0;
                }
                else {
                    if(charArr[i]==charArr[j] && dp[i+1][j-1]!=0)
                        dp[i][j]= dp[i+1][j-1]+2;
                    else dp[i][j]=0;
                }
                
                if(dp[i][j]!=0){
                        ans = s.substring(i,j+1);
                }
                    
            }
        }
        
        
        return ans;
       
    }
}
