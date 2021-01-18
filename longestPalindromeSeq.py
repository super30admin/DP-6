#Dp solution
#Time: O(n^2)
#Space: O(1)


class Solution:
    def longestPalindrome(self, s: str) -> str:
        self.maxs = 0
        n = len(s)
        self.start = len(s)
        self.end = 0
        for i in range(n):  
            self.checkPalindrome(s, i,i)
            if i < n-1 and s[i]  == s[i+1]:
                self.checkPalindrome(s, i,i+1)
                
        return s[self.start:self.end]
        
    def checkPalindrome(self, s, left, right):
        while (left>=0 and right<len(s) and s[left] == s[right]):
            if self.maxs < right-left+1:
                self.maxs = right-left+1
                self.start = left
                self.end = right + 1
            left-=1
            right+=1
        
        return 
#Dp solution
#Time: O(n^2)
#Space: O(n^2)

class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxs = 1
        start  = 0
        end = 0
        n = len(s)
        if not s:
            return s
        if n < 2:
            return s
        dp = [[False for _  in range(n)] for _ in range(n)]
        
        for i in range(n):
            for j in range(i):
                if s[i] == s[j] and (i-j<=2 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if maxs<i-j+1:
                        maxs = i-j+1
                        start = j
                        end =  i
                        
        print(start,end)                
        return s[start:end+1]