//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        //base case
        //1 character is a palindrome
        if(n < 2)
            return s;
        boolean [][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;
        //i: 0 -> n
        //j: i -> 0
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                //if characters are equal, i-j<2 ('bab'|'bb'|'b')
                if(s.charAt(i) == s.charAt(j) && (i-j <= 2 || dp[i-1][j+1])){
                    //set dp array to true
                    dp[i][j] = true;
                    //if prev lenth of the palindrome is < i-j; update
                    if(i - j > end - start){
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}