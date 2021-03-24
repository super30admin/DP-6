"""
Time Complexity : O(N^2)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
METHOD 1 : DP n^2
1. 2 for loops from i=0 to len
    j from 0 to i
2. if chars are equa and [difference between them is less than 2 or dp[i-1][j+1] is True
    then make dp[i][j] = True
3. if max is changed update the start and end

METHOD 2: Two pointers
1. put pointers at each location and go left and right
2. if they are not equal then continue
3. if equal and length is more then change start and end
after this JING BANG return substring with max length 
"""
class Solution:
    def __init__(self):
        self.mx = 1
        self.start = 0
        self.end = 0
        self.mx = 1
        
    def longestPalindrome(self, s: str) -> str:
        n = len(s)

        def extendAroundIndex(left, right):
            while left>=0 and right <n and s[left] == s[right]:
                left -= 1
                right += 1
            if self.mx<right - left - 1:
                self.mx = right - left -1
                self.start = left + 1
                self.end = right -1
            
        
        for i in range(1, n):
            extendAroundIndex(i, i)
            if s[i] == s[i-1]:
                extendAroundIndex(i, i-1)
        return s[self.start: self.start+self.mx]
                   
        
class Solution1:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False]*(n+1) for _ in range(n)]
        mx = 1
        start = 0
        end = 0
        
        for i in range(n):
            for j in range(i+1):
                if s[i] == s[j] and (i-j < 2 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if mx < i-j+1:
                        mx = i-j+1
                        start = j
                        end = i
        return s[start: start+mx]
                    