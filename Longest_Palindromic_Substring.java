
class Solution {
    int start=0, max = 0;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return s;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            extendPalindrome(s, i, i);
            if(i!=n-1 && s.charAt(i) == s.charAt(i+1))
            {
                extendPalindrome(s,i, i+1);
            }
        }
      //  System.out.println(start+"--"+max);
        return s.substring(start, start+max);
    }
    private void extendPalindrome(String s, int left, int right)
    {
        // System.out.println(left+":"+right);
        while(left >=0 && right<s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
          //  System.out.println(right-left-1);
            if(max < right-left-1)
            {
                start = left+1;
                max = right-left-1;
            }
        }
    }
}

//Time complexity: O(n ^ 2)
//Space complexity: O(n ^ 2)

class Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start=0, end =0; int max = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i;j>=0;j--)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    if(i-j < 2 || dp[i-1][j+1])
                        dp[i][j] = true;
                }
                if(dp[i][j] == true)
                {
                    if(max < i-j+1)
                    {
                        max = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
}

//Time complexity: O(n ^ 2)
//Space complexity: O(1)