//time complexity-O(n^2)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-Yes
class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {//consider each element as centre of palindrome and exapand out on its start and end
            int len1=expand(s,i,i);//exapnd the string from single centre element
            int len2=expand(s,i,i+1);//expanding the string from two elements in centre
            int len=Math.max(len1,len2);
            if(len>end-start)
            {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expand(String s, int left, int right)//function to find the palindrome by exapnding start,end
    {
        int L=left, R=right;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R))
        {
            L--;
            R++;
        }
        return R-L-1;
        
    }
}