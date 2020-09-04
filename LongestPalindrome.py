# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Dp Solution
# Time Complexity : O(n^2)
# Space Complexity :O(n^2)
class Solution:
    def longestPallindrome(self, s):
        if len(s) == 0:
            return ''
        
        dp = [[False for _ in range(len(s))] for _ in range(len(s))]
        start,end = 0, 0 
        for i in range(len(dp)):
            for j in range(i, -1, -1):
                if s[i] == s[j] and (i-j <= 2 or dp[i-1][j+1]):
                    dp[i][j] = True 
                    if end - start < i - j :
                        start = j 
                        end = i 
        
        return s[start : end +1]
            
if __name__ == "__main__":
    s = Solution()
    res = s.longestPallindrome("babad") 
    assert res == 'bab'