#Time , space O(n**2)
class Solution:

    m=start=end=0 
    def longestPalindrome(self, s: str) -> str:
        
        if s is None or len(s)==0:return ""
        mv=s[0]
        n=len(s)
        #Traverse every character and call expand for every character
        for i in range(n):
            self.expand(s,i,i)
            if i+1<n and s[i]==s[i+1]:
                self.expand(s,i,i+1)
        
        return s[self.start:self.end+1]
    
    #expand left and right
    def expand(self,s,l,r):
        while l>=0 and r<len(s) and s[l]==s[r]:
            l-=1
            r+=1
            
        l+=1
        r-=1
        
        if (r-l+1) > self.m:
            self.m = r-l+1
            self.start=l
            self.end=r
