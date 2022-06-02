#Time Complexity: O(N)
#Space Complexity: O(NlogN)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        self.maxx = 0
        self.startindex = 0
        self.endindex = 0
        for i in range(0,len(s)):
            if self.endindex - self.startindex == len(s):
                return s
            self.extend(s,i,i)
            if i < len(s)-1 and s[i] == s[i+1]:
                self.extend(s,i,i+1)
                
        return s[self.startindex:self.endindex+1]
                
    def extend(self,strr,start,end):
        
        while start >= 0 and end < len(strr) and strr[start] == strr[end]:
            start -=1
            end +=1
        
        astart = start + 1
        ahigh = end - 1
        
        if ahigh - astart + 1 > self.maxx:
            self.maxx = ahigh - astart + 1
            self.startindex = astart 
            self.endindex = ahigh
            return start,end
        
            

            