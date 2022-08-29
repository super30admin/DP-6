""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        resLength = 0
        for i in range(len(s)):

            l, r = i, i

            while (l >= 0 and r < len(s) and s[l] == s[r]):
                if (r - l + 1) > resLength:
                    resLength = r - l + 1
                    res = s[l:r + 1]
                l -= 1
                r += 1

            l, r = i, i + 1

            while (l >= 0 and r < len(s) and s[l] == s[r]):
                if (r - l + 1) > resLength:
                    resLength = r - l + 1
                    res = s[l:r + 1]

                r += 1
                l -= 1
        return res


""""// Time Complexity : O(n^2)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def longestPalindrome(self, s: str) -> str:
#         n=len(s)
#         dp=[[False for j in range(n)] for i in range(n)]
#         dp[0][0]=True
#         start=0
#         end=0
#         for i in range(n):
#             for j in range(i+1):
#                 if s[i]==s[j]:
#                     if i-j<2 or dp[i-1][j+1]:
#                         dp[i][j]=True
#                         if end-start<i-j:
#                             end=i
#                             start=j
#         return s[start:end+1]



