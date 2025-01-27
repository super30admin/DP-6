class Solution:
    def longestPalindrome(self, s: str) -> str:
        s1= ""
        count = 1

        for i in range(len(s)):
            
            #for odd substrings
            l, r = i, i
            while (l>=0 and r<len(s) and s[l]==s[r]):
                s2 = s[l:r+1]
                if (len(s2)>=count):
                    s1 = s[l:r+1]
                    count = max(count,r-l+1)
                l = l-1
                r = r+1
                    
            #for even substring
            l ,r = i, i + 1
            while (l>=0 and r<len(s) and s[l]==s[r]):
                s2 = s[l:r+1]
                if (len(s2)>=count):
                    s1 = s[l:r+1]
                    count = max(count,r-l+1)
                l = l-1
                r = r+1    
               
        return s1    
        
        