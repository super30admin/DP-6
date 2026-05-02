class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        def expand(l, r):
            while l>=0 and r<n and s[l]==s[r]:
                l-=1
                r+=1
            
            return l+1,r-1
        
        start = end = 0
        for idx in range(n):
            #odd
            lo, ro = expand(idx,idx)

            #even
            le, re = expand(idx, idx+1)

            if ro-lo > end - start:
                start, end = lo, ro
            
            if re-le > end - start:
                start, end = le, re
        
        return s[start:end+1]

            
