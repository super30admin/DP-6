# Problem 1: Longest Palindromic Substring
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        i,j = 0,0
        start, end = 0,0

        for i in range(n):
            for j in range(0,i+1):
                if s[i] == s[j]:
                    if i - j <= 1 or dp[i-1][j+1]:
                        dp[i][j] = True
                        if i - j > end - start:
                            start = j
                            end = i
                    else:
                        dp[i][j] = False
                else:
                    dp[i][j] = False

        return s[start:end+1]
        
        