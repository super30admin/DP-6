
"""
Time Complexity : O(n^2) for DP solution as well as the other solution
Space Complexity : O(n^2) fopr DP solution due to a 2D matrix and O(1) for the other
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, I have implemented 2 solution, DP(commented) and the extending around the center. For DP nsolution, we already have
repeated subproblem of substrings that have already been classified as a palindrome or not. For the other solution, for every character,
we will treat it as center of the string and extend in its left and right to check if its a palindrome or not. We would
take into account both odd and even cases. Also, as soon as the maximum becomes equal to string length, we do not need to check anymore
as that could be the maximum value possible, and we break.
"""


class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        if not s or n < 2:
            return s
        self.maximum = 1
        self.start = 0
        for i in range(n):
            self.checkPalindrome(s, i, i)
            if i < n-1 and s[i] == s[i+1]:
                self.checkPalindrome(s, i, i+1)
            if self.maximum == n:
                break
        return s[self.start:self.start+self.maximum]

    def checkPalindrome(self, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        if right-left-1 > self.maximum:
            self.maximum = right-left-1
            self.start = left+1
# class Solution:
#     def longestPalindrome(self, s: str) -> str:
#         if not s:
#             return s
#         n=len(s)
#         dp=[[False for i in range(n)] for j in range(n)]
#         maximum=1
#         start,end=0,0
#         for i in range(n):
#             for j in range(i):
#                 if s[i]==s[j] and (i-j<=2 or dp[i-1][j+1]):
#                     dp[i][j]=True
#                     if (i-j+1)>maximum:
#                         maximum=i-j+1
#                         start=j
#                         end=i
#         return s[start:end+1]
