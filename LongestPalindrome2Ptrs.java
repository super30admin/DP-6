class Solution {
    //tc-o(n^2)
    //sc-o(1)
    int start, end;
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            extendAroundCenter(i,i,s);//odd
            if(i<n-1&& s.charAt(i) == s.charAt(i+1))
            {
                extendAroundCenter(i,i+1,s);//even
            }

        }
        return s.substring(start,end+1);
    
    }
    private void extendAroundCenter(int l,int r,String s)
    {
        while(l>=0&&r<=s.length()-1&& (s.charAt(l)==s.charAt(r)))
        {
            l--;
            r++;
        }
        l++;
        r--;
        if(r-l > end-start)
        {
            end=r;
            start = l;
        }

    }
}