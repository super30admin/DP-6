
public class LongestPanidromeSubstring {
	// Time O(N^2)
	// Space O(N^2)
	
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int maxStartsAt = 0;
        // all palindrome of length 1
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            maxStartsAt=i;
        }
        
        // all palindrome of length 2
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                maxStartsAt=i;
                maxLength=2;
            }
        }

        // All Palindrome of length 3 and more
        for(int length=3;length<=n;length++){
            for(int i=0;i<=n-length;i++){
                int j = i+length-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        maxLength=length;
                        maxStartsAt=i;
                    }
                }
            }             

        }
        return s.substring(maxStartsAt,maxStartsAt+maxLength);   
    }
}
