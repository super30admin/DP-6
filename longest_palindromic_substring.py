# Time Complexity : O(n^2)
# Space Complexity : O(n)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return ""
        
        n = len(s)
        start = 0
        end = 0
        dp = [False]*n 
        dp[0] = True
        for i in range(n):
            for j in range(0, i+1):
                if s[i] == s[j]:
                    if i-j < 2 or dp[j+1]:
                        dp[j] = True
                        if i - j > end - start:
                            start = j
                            end = i
                    else:
                        dp[j] = False
                else:
                    dp[j] = False
        
        return s[start:end+1]