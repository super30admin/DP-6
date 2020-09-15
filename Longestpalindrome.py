#T: O(M+N)
#S: 0(1)
#Tested on Leetcode

class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        self.start = 0
        self.maxLen = 0
        
        n = len(s)
        
        if len(s) < 2: #Edge case
            return s
        
        for i in range(n):
            #checking if a string is palindrome or not
            self.checkpalindrome(s,i,i) 
            self.checkpalindrome(s,i,i+1)
        
        return(s[self.start: (self.start + self.maxLen)])
    
    def checkpalindrome(self, s, left, right):
        while(left>=0 and right <len(s) and (s[left] == s[right])): # if the characters match moving towards left and right of that character
            left-=1
            right+=1
        if (right - (left+1) > self.maxLen): # updating the maximum length
            self.maxLen = right - (left+1)
            self.start = left + 1
        