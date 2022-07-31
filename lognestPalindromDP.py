'''
time complexity: O(n2)
space complexity: o(n2)
'''
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        n = len(s)
        dp = [[False for _ in range(n)] for i in range(n)]
        dp[0][0] = True
        end = 0
        start = 0
        for i in range(1,n):
            for j in range(0,i+1):
                if(s[i]==s[j] and (i-j<2 or dp[i-1][j+1])):
                    dp[i][j] = True
                    if(end-start<i-j):
                        end = i
                        start = j
        return s[start:end+1]