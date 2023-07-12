//TC: O(n^2)
//TC: O(n)
/**
 * First take dp matrix of size n. Then fill diagonals with true. Then iterate
 * till last but one row and check i and i+1 chars if equal, mark the dp[i][i+1]
 * as true. In next step take length from 3 to n and check if 1st and last char
 * matches, if so, then check remaining chars match by checking i+1, j-1 th
 * index of dp matrix. update max with k and note start index. Finally return
 * start + max substring.
 *
 */
class Solution {
    int start; 
    int end;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        boolean[] dp = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(s.charAt(i) == s.charAt(j) && ((i-j) < 2 || dp[j+1])){
                    dp[j] = true;
                    if(i-j> end-start){
                        start = j;
                        end = i;
                    }
                }else{
                    dp[j]= false;
                }
            }
        }
        return s.substring(start, end+1);
    }
}
