class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return s

        n = len(s)
        # maximum = 0
        start = 0
        end = 0
        dp = [[False] * n for i in range(n)]

        for i in range(n):
            for j in range(0, i + 1):
                if s[i] == s[j] and ((i - j) < 2 or dp[i - 1][j + 1]):
                    dp[i][j] = True
                    if (i - j) > (end - start):
                        start = j
                        end = i
        return s[start: end + 1]

# Dynamic Programming
# Time Complexity :O(n^2)
# Space Complexity :O(n^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
