//Time complexity : O(n^2) Since expanding a palindrome around its center could take O(n) time, the overall complexity is O(n^2) 
//TC: O(N*N)
//SC: O(1)
//Did it run successfully on Leetcode? : Yes
class Solution {
    int resultBegin;
    int resultLength;
    public String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        for (int start = 0; start < s.length(); start++)
        {
            expandRange(s, start, start);   // for odd length strings  babad
            expandRange(s, start, start+1); // for even length strings abba
        }
        return s.substring(resultBegin, resultBegin + resultLength );
    } 
    private void expandRange(String s, int begin, int end)
    {
        while ( begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end))
        {
            begin--;
            end++;
            
            if (resultLength < end - begin -1 )
            {
                resultBegin = begin + 1;
                resultLength = end - begin - 1;
            }
        }
    }
}

//DP : Here subproblems are repeated for finding the whether the current substring is pallindrome or not
//TC: O(N*N)
//SC: O(N*N)
//Did it run successfully on Leetcode? : Yes
class Solution {
    int maxLen;
    int start;
    int end;
      public String longestPalindrome(String s) {
          maxLen = 0;
          start = 0;
          end = 0;
          int n = s.length();
          boolean[][] dp = new boolean[s.length()][s.length()];
          for (int i = 0; i < dp.length; i++){
              dp[i][i] = true;
          }
          for (int i = 0; i < dp.length; i++){
             for (int j = 0; j < i; j++){
                 if (s.charAt(i) == s.charAt(j) && (i-j < 2 || dp[i-1][j+1])){
                         dp[i][j] = true;
                         if (i-j > maxLen){
                            maxLen = i - j ;
                            start = j;
                            end = i;
                    }
                 }
              }
              if ( i == n)
                  break;
           }
       return s.substring(start, end + 1);
    }
}

