"""
Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)
"""

# Approach - 1

class Solution:
    def longestPalindrome(self, s: str) -> str:
        """
        TC:O(N^2) N : len of s
        SC:O(N^2)
        """
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        start, end = 0, 0
        for i in range(n):
              for j in range(i+1):
                    if ((s[i] == s[j]) and ((i - j <= 2) or (dp[i + 1][j - 1] == True))):
                        dp[i][j] = True
                    # if the current difference of length is greater than earlier one, then update the start and end pointer
                        if ((i - j) > (end - start)):
                            start = j
                            end = i
        return s[start: end + 1]


# Approach - 2

class Solution:
    def longestPalindrome(self, s: str) -> str:
        """
        TC: O(N^2)
        SC: O(1)
        """
        start, end = 0,0
        n = len(s)
        def helper(s,  l, r):
            nonlocal start, end
            while (l >= 0 ) and (r <= len(s) -1) and (s[l] == s[r]):
                l -= 1
                r += 1
            
            l += 1
            r -= 1
            if (r - l) > (end - start):
                end = r
                start = l
        
        for i in range(n):
            
            helper(s, i, i)
            if (i < n -1):
                helper(s, i, i + 1)
                
        return s[start : end + 1]
      