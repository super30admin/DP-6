//loop through each character and expand around if the characters match and 
//track max length along with start and end pointers and then return sub string 
//Time Complexity: O(n^2)
//Space Complexity: O(1)
class Solution {
    int max;
    int start,end;

    public String longestPalindrome(String s) {
        int n = s.length();
        this.max = 0;
        start = 0;end = 0;
        for(int i=0;i<n;i++)
        {
            //odd length
            extendsAround(s,i,i);
            //even length
            if(i<n-1 && s.charAt(i)==s.charAt(i-1))
            {
                extendsAround(s,i,i+1);
            }
        }
        return s.substring(start,end+1);
    }

    private void extendsAround(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;
            right++;
        }
        left++;
        right--;

        if(max<right-left+1)
        {
            max = right-left+1;
            start = left;
            end = right;
        }
    }
}