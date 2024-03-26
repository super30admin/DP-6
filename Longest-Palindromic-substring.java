/*Time Complexity: O(N*N)

Space Complexity: O(N*N)

Did this code successfully run on Leetcode : Yes

Approach: Tabulation - Bottom up

Prob: 413. Arithmetic Slices
*/

class Solution {
    int start;int end;
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int i = 0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = false;
                }
                else{
                    if(i - j < 2 || dp[i-1][j+1]){
                        dp[i][j] = true;
                        if(i - j > end - start){
                            start = j;
                            end = i;
                        }  
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}