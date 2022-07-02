//TC : O(n^2)
//SC : O(1)
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int start = 0;
        int end = 0;
        int result = 1;
        for(int i=0;i<s.length();i++){

            //for odd length
            int l=i;
            int r =i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                int len = r-l+1;
                if(len>result)
                {
                    result = len;
                    start = l;
                    end=r;
                }
                l--;
                r++;
            }
            //for even length
            l=i;
            r =i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
            {
                int len = r-l+1;
                if(len>result)
                {
                    result = len;
                    start = l;
                    end=r;
                }
                l--;
                r++;
            }
        }
        return s.substring(start,end+1);
    }
}