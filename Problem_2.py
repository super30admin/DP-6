# Dynamic Programming Solution
# Time Complexity: O(n*n)
# Space Complexity: O(n*n)

class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == None or len(s) == 0:
            return ""
        n = len(s)
        maxLen, start, end = 0, 0, 0
        dp = [[False for j in range(n)] for i in range(n)]
        for i in range(n):
            for j in range(i+1):
                if s[i] == s[j] and ((i-j < 2) or dp[i-1][j+1] == True):
                    dp[i][j] = True
                    if i-j + 1 > maxLen:
                        maxLen = i-j+1
                        start = j
                        end = i
        return s[start:end+1]



# Time Complexity: O(n*n)
# Space Complexity: O(1)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == None or len(s) == 0:
            return ""
        n = len(s)
        self.maxLen, self.start, self.end = 0, 0, 0
        
        for i in range(n):
            self.extendAroundCentre(s, i, i)
            if i < n -1 and s[i] == s[i+1]:
                self.extendAroundCentre(s, i, i+1)
        return s[self.start: self.end+1]
    
    def extendAroundCentre(self, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        left += 1
        right -= 1
            
        if (right - left + 1) > self.maxLen:
            self.maxLen = right - left + 1
            self.start = left
            self.end = right
            