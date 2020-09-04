# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Method 1) DP 
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
    
# Method 2) Pick any character at i and check for even and odd substrings surrounding it for pallindrome & its length.
# Time Complexity : O(n^2)
# Space Complexity :O(n^2)
class Solution:
    start, end = None, None
    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0:
            return ''
        self.start, self.end = 0 , 0
        for i in range(len(s)):
            # even case 
            self.check(s, i, i)
            
            # off case 
            if i+1 < len(s) and s[i] == s[i+1]:
                self.check(s, i ,i+1)
        print(self.start, self.end)
        return s[self.start:self.end+1]
    
    def check(self,s, left, right):
        while left <= right:
            if left >= 0 and right < len(s) and s[left] == s[right]:
                if left >=0 and right < len(s) and self.end - self.start < right - left:
                    self.end = right
                    self.start = left
                left -= 1 
                right += 1  

            else:
                break 

        return 
            
            
if __name__ == "__main__":
    s = Solution()
    res = s.longestPallindrome("babad") 
    assert res == 'bab'