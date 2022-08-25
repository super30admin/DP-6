//****172.5.Longest Palindromic Substring****
//Time complexity: o(n) square
//Space complexity: 0(1);
//Leetcode runnable - y;
//Any doubts:No;

class Solution {
    int start;
    int end;
    public String longestPalindrome(String s) {
    
        //Null case
        if(s.length()==0) return s;
        
        for(int i=0;i<s.length();i++)
        {
            //for odd
            extendstring(s, i, i);
            //for even
            if(i<s.length()-1 && s.charAt(i)==s.charAt(i+1))
            {
                extendstring(s, i, i+1);
            }
            
        }
        return s.substring(start, end+1);
    }
    
    private void extendstring(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        
        if(end-start<(right-1)-(left+1))
        {
            start=left+1;
            end=right-1;
        }
    }
}
