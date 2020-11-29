//Time Complexity-O(n*m)
//Space-O(1)
class Solution {
    int start=0;
    int end=0;
        
    public String longestPalindrome(String s) {
        if(s==null||s.length()<2)
        {
            return s;
        }
        for(int i=0;i<s.length();i++)
        {
            checkForPalindrome(s,i,i);
            if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1))
            {
                checkForPalindrome(s,i,i+1);
            }
        }
        return s.substring(start,end+1);
    }
    private void checkForPalindrome(String s,int left,int right)
    {
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        left++;
        right--;
        if(end-start<right-left)
        {
            start=left;
            end=right;
        }
    }
}