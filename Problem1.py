class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False] * (n) for _ in range(n)]

        dp[0][0] = True
        start = 0
        end = 0
        for j in range(1,n):
            for i in range(j,-1,-1):
                if s[j] != s[i]:
                    dp[i][j] = False
                else:
                    if j - i < 2 or dp[i+1][j-1]:
                        dp[i][j] = True
                        if j -i > end - start:
                            start = i
                            end = j
        

        return s[start:end+1]
