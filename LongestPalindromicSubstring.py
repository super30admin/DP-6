"""
Time Complexity : O(n) where n is the length of string s
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        stringForPalindrome = ""
        longestPalindrome = ""
        if(s== ""):
            return ""
        # We take the string and start from an index and spread or look at the char
        # after and before and check for that string to be palindromic. Basically
        # we increase the charcter and look at both odd and even length palindromes
        for i in range(len(s)):
            stringForPalindrome = self.isPalindrome(s, i, i)
            if len(stringForPalindrome) > len(longestPalindrome):
                longestPalindrome = stringForPalindrome
            
            stringForPalindrome = self.isPalindrome(s, i, i + 1)
            if len(stringForPalindrome) > len(longestPalindrome):
                longestPalindrome = stringForPalindrome
        return longestPalindrome
            
    def isPalindrome(self, s, leftIndex, rightIndex):
        while 0 <= leftIndex <= rightIndex < len(s) and s[leftIndex] == s[rightIndex]:
            leftIndex -= 1
            rightIndex += 1
        return s[leftIndex + 1 : rightIndex]
        
        