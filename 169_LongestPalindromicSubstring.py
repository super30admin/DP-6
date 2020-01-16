'''
Accepted on leetcode(5)
time - O(N^2)
space - O(N^2)
'''


class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # 1) edge case: if len(s) == 0

        if len(s) == 0:
            return ""
        # 2) initialize and create dp matrix

        N = len(s)
        dp = [[False for i in range(N)] for i in range(N)]

        start = 0
        end = 0
        # 3) traverse through matrix and check for palindrome

        for i in range(N):
            for j in range(i, -1, -1):
                # 4) check for 2 cases if char at i and j match
                if (s[i] == s[j] and ((i - j <= 2) or dp[i - 1][j + 1] == True)):
                    dp[i][j] = True
                    if i - j > end - start:
                        start = j
                        end = i

        return s[start:end + 1]