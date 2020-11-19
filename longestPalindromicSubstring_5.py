# // Time Complexity : O(n^2)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Problems encountered? No

# // Your code here along with comments explaining your approach
# Keep L and R pointers at every index and keep expanding to check if the substring is valid palindrome. Update start and end indices along the way
#Edge case- eg: babbab, bb breaks the code

class Solution:
    def __init__(self):
        self.start = 0
        self.end = 0
            
    def longestPalindrome(self, s: str) -> str:
        
        if s==None or len(s)<2:
            return s
        
        n = len(s)
        
        for i in range(n):
            self.helper(s,i,i)
            if i < n-1 and s[i]==s[i+1]:
                self.helper(s, i,i+1)
                
        return s[self.start:self.end+1]
        
        
    def helper(self,s, left, right):
        #keep expanding left and right pointers until the string is palindromic
        while left >= 0 and right<len(s) and s[left]==s[right]:
            left -= 1
            right += 1
        #when out of bounds or chars are unequal: get to correct indices
        left += 1
        right -= 1
        
        if self.end - self.start < right-left:
            self.start = left
            self.end = right
            
        