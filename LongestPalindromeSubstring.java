class LongestPalindromeSubstring {
    int start;
      int end;
   public String longestPalindrome(String s) {
     int n= s.length();
     for(int i=0;i<n;i++)
     {
       extendAroundCenter(s,i,i);
       if(i< n-1 && (s.charAt(i)== s.charAt(i+1)))
       {
            extendAroundCenter(s,i,i+1);
       }
     }
       return s.substring(start,end+1);
   }

   private void extendAroundCenter(String s, int l, int r)
   {
       int n= s.length();
       while(l>=0 && r<n && s.charAt(l)== s.charAt(r))
       {
           l--;
           r++;
       }
       l++;
       r--;
       if(r-l > end - start)
       {
           end = r;
           start =l;
       }
   }
}

//tc: O(n ^ 2)
//sc: O(1)