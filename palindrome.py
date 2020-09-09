# STEPS:
# From every index in the string, check whether the substring is a palindrome.
# Time complexity - O(n^3)  
#           O(n^2) for forming the substring and O(n) for checking whether it is a palindrome.
# Space complexity - O(1)
# Did this solution run on leetcode? - no (TLE)
class Solution:
    
    def longestPalindrome(self, s: str) -> str:
        n = len(s)          # length of string s
        # # edge case
        # if n==1:
        #     return s
        
        i = 0
        maxLen = 0
        maxSubstring = ""
        # From every location in the string, check whether the substring is a palindrome.
        while i<= n-1:
            for j in range(i, n):
                if self.isPalindrome(s, i, j+1) and maxLen < j-i+1:
                    maxSubstring = s[i:j+1]
                    maxLen = j-i+1
            i+=1
        return maxSubstring

    
    def isPalindrome(self, s, i, l):
        # Check whether the substring is a palindrome.
        while i<=l-1:
            if s[i] != s[l-1]:
                return False
            i+=1
            l-=1
        return True
        

# Using dynamic programming
# dp[i, j] = dp[i-1, j+1] if s[i]==s[j] (check whether the substring inside is valid if the length of substring is greater than 1.)
# dp[i, i] = True
# Time complexity - O(n^2)
# Space complexity - O(n^2)
# Did this solution run on leetcode? - yes
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s) # length of string
        # dp array
        dp = [[False for _ in range(n)] for _ in range(n)]
        
        start, maxLen = 0, 1
        for i in range(n):
            dp[i][i] = True
            for j in range(i-1, -1, -1):
                # check whether the characters match and the substrings inside match too.
                # Also keep the track of maximum length substring.
                if s[i]==s[j] and (i-j <= 1 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if maxLen <= (i - j):
                        start = j
                        maxLen = i-j+1

        return s[start:start+maxLen]
        

# Expand around the center.
# Check whether 
# Time complexity - O(n^2)
# Space complexity - O(1) constant extra space.
# Did this solution run on leetcode? - yes
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s) # length of string
        # edge case
        if n==1:
            return s
        
        start, maxLen = 0, 1
        i = 0
        while i < n:
            # find the max length substring from i which is a palindrome
            # odd case
            begin, sLen = self.isPalindrome(s, i, i)
            if maxLen < sLen:       # keep track of maximum length palindrome.
                start = begin
                maxLen = sLen
            
            # even case
            if i+1 < len(s) and s[i] == s[i+1]:
                begin, sLen = self.isPalindrome(s, i, i+1) 
                if maxLen < sLen:   # keep track of maximum length palindrome.
                    start = begin
                    maxLen = sLen
            i+=1
    
        return s[start:start+maxLen]
            
    def isPalindrome(self, s, i, l):
        # Expand the substring around the center until it is a palindrome.
        while i>=0 and l<len(s) and s[i]==s[l]:            
            i-=1
            l+=1
        return i+1, l-i-1 # return the start index and length of palindrome.
              
                