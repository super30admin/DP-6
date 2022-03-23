// Time Complexity : O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take two pointer and compare from each char index, for even more the one pointer towards rigt (i+1)
// Your code here along with comments explaining your approach
class Solution {
    int start; int end;
    public String longestPalindrome(String s) {
        if( s== null || s.length() < 2) return s;
        int n = s.length();
        for(int i = 0; i < n; i++){
            pointer(s,i,i); // odd case
            pointer(s,i,i+1); // odd case
        }
        return s.substring(start, end+1);
    }
    private void pointer(String s, int l, int r){
        while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--; r++;
        }
        // left is more lefter and right is more righter
        l++; r--;
        if( r - l > end - start){
            start = l;
            end = r;
        }
    }
}

// DP - solution
// Time Complexity : O(n*n)
// Space Complexity :O(n*n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// take a string to string matrix and check if both character is same, if yes then check if they are only two character to compare ( i - j > 2) , or there inncer string is palindrome or not by suberray dp[i-1][j+1].
// Your code here along with comments explaining your approach
// class Solution {
//     public String longestPalindrome(String s) {
//         if( s == null || s.length() < 2 ) return s;
//         int n = s.length();
//         boolean [][] dp = new boolean [n][n];
//         int start = 0;
//         int end = 0;
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j <= i; j++){
//                 if(s.charAt(i) == s.charAt(j) && ( (i - j <2) || dp[i-1][j+1])){
//                      dp[i][j] = true;
//                      if( i - j > end - start){
//                          start = j;
//                          end = i;
//                      }
//                 }
//             }
//         }
//         return s.substring(start,end+1);
//     }
// }
