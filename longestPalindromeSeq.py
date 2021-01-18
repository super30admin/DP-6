#Dp solution
#Time: O(n^2)
#Space: O(n^2)


class Solution:
    def longestPalindrome(self, s: str) -> str:
        self.maxs = 0
        n = len(s)
        self.start = len(s)
        self.end = 0
        for i in range(n):  
            self.checkPalindrome(s, i,i)
            if i < n-1 and s[i]  == s[i+1]:
                self.checkPalindrome(s, i,i+1)
                
        return s[self.start:self.end]
        
    def checkPalindrome(self, s, left, right):
        while (left>=0 and right<len(s) and s[left] == s[right]):
            if self.maxs < right-left+1:
                self.maxs = right-left+1
                self.start = left
                self.end = right + 1
            left-=1
            right+=1
        
        return 