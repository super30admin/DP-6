# Time Complexity : O(N^2)
# Space Complexity : O(N^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        
        if n < 2:
            return s
        
        dp = [[0 for j in range(n)] for i in range(n)]
        mx = start = end = 0
        
        for i in range(n):
            for j in range(i-1,-1,-1):
                if s[i] == s[j] and (i-j <= 2 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if i-j+1> mx:
                        mx = i-j+1
                        start = j 
                        end = i
                    if mx == n:
                        break
        return s[start:end+1]