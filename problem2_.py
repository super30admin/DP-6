# Time complexity: O(n)
# Space Complexity : O(n)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""

        n = len(s)
        dp = [[False] * n for i in range(n)]

        _max = 0
        start = 0
        end = 0

        for i in range(0, n):
            for j in range(0, i + 1):
                if s[i] == s[j] and (i - j < 3 or dp[i - 1][j + 1]):
                    dp[i][j] = True
                    if _max < i - j + 1:
                        _max = i - j + 1
                        start = j
                        end = i

        return s[start:end + 1]



