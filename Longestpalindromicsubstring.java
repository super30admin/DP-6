//time O(n^2)
//space O(1)

class Solution {
    public String longestPalindrome(String s) {
        int maxlen=0;
        int start=0, end=0;
        for(int i =0;i<s.length();i++)
        {
            int l1 = checkPalindrome(i,i,s); //odd
            int l2 = checkPalindrome(i,i+1,s); //even
            int l = Math.max(l1,l2);
            //System.out.println(l);
            if(l>maxlen)
            {
                start = i - ((l-1)/2);
                end = i+ l/2;
                maxlen=l;
            }
            
        }
        return s.substring(start,end+1);
    }
    private int checkPalindrome(int start, int end, String s)
    {   if(s==null || start>end)
        return 0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        { 
          start--;
          end ++;
        }
        return end-start-1;
    }
}