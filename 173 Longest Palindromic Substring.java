
// Time Complexity : O(n^2)
// Space Complexity : O(n+m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    //aesha
    int start,end;
    public String longestPalindrome(String s) {
        int n=s.length();

        for(int i=0;i<n;i++)
        {
            extendAround(s, i, i);
            if(i > 0 && s.charAt(i) == s.charAt(i - 1))
            
            {
                extendAround(s, i-1, i);
            }
        }
        return s.substring(start, end+1);
    }

    private void extendAround(String s, int left, int right)
    {
        while(left>=0 && right< s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        left++;
        right--;

        if(right-left > end-start)
        {
            start = left;
            end = right;
        }

    }
}
