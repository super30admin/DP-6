class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s or len(s)==0:
            return ""
        self.start=self.end=0

        def helper(s,left,right):
            while left>=0 and right<=len(s)-1 and s[left]==s[right]:
                left-=1
                right+=1
            
            left+=1
            right-=1
                
            if right-left+1>self.end-self.start+1:
                self.start=left
                self.end=right        
        
        for i in range(len(s)):
            helper(s,i,i)
            helper(s,i,i+1)
            
        return s[self.start:self.end+1]
            
        
        
        
                        
        