#To solve this problem, we use the 2 pointer approch
#Time Complexity: O(n^2)
#Space Complexity: O(1)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2:
            return s
        n = len(s)
        dp = [[0 for i in range(n)]for i in range(n)]
        max = 1
        start = 0
        end = 0
        for i in range(n):
            for j in range(i+1):
                if s[i] == s[j] and (i-j < 2 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if max < i-j+1:
                        max = i-j+1
                        start = j
                        end = i
        return s[start:end+1]