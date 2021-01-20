#Time Complexity : O(n^2)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def expandAroundCenter(self, i, j, s, n):
        while i >= 0 and j < n and s[i] == s[j]:
            i -= 1
            j += 1

        return s[i+1:j]

    def longestPalindrome(self, s: str) -> str:
        if len(s) < 2:
            return s
        n = len(s)
        result = ""
        for i in range(n):
            #odd
            temp = self.expandAroundCenter(i, i, s, n)
            if len(temp) > len(result):
                result = temp
            #even
            temp = self.expandAroundCenter(i, i+1, s, n)
            if len(temp) > len(result):
                result = temp

        return result

# DP: TC - O(n^2), SC - O(n^2)
#         dp = [[False for _ in range(n)] for _ in range(n)]
#         maxi, start, end = 1, 0, 0

#         for i in range(n):
#             for j in range(i+1):
#                 if s[i] == s[j] and ((i-j < 2) or dp[i-1][j+1]):
#                     dp[i][j] = True
#                     if maxi < i-j+1:
#                         maxi = i-j+1
#                         start, end = j, i


#         return s[start:end+1]
