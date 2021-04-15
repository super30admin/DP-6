#Time Complexity:O(n^2)
#Space Complexity:O(1)
#Approach: Use two pointers left and right. Parse through each character of string considered as pivot. check on either sides to check for 
#palindrome. Compare lengths of palindroms encountered and return the maximum.
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s)<2:
            return s
        self.n=len(s)
        self.start=0
        self.end=0
        for i in range(self.n):
            self.extendAroundPivot(s,i,i)
            if i<self.n-1 and s[i]==s[i+1]:
                self.extendAroundPivot(s,i,i+1)
        return s[self.start:self.start+self.end]
            
    def extendAroundPivot(self,s:str,left:int,right:int)->None:
        while left>=0 and right<self.n and s[left]==s[right]:
            left-=1
            right+=1
        if right-left-1>self.end:
            self.end=right-left-1
            self.start=left+1