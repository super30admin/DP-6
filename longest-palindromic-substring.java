class Solution {
    //TC: O(m*n)
    //SC : O(n)
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int n = s.length();
        boolean [] dp = new boolean[n];
        int start = 0, end = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <=i; j++){
                if(s.charAt(i) != s.charAt(j)) {
                    dp[j] = false;
                }else{
                    if(i - j < 2 ||  dp[j+1]){
                        dp[j] = true;
                        if(i - j > end - start){
                            start = j;
                            end  = i;
                        }
                    }else{
                        dp[j] = false;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}
