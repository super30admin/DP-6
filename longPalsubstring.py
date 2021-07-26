"""TC - O(n^2)
SC - O(1)
Approach -2 pointer solution at each point"""
class Solution:
    def __init__(self):
        self.maxL = 0
        self.start = 0
        self.end = 0
    def longestPalindrome(self, s: str) -> str:
        if s ==None:
            return None
        n = len(s)
        for i in range(n):
            self.extendAroundCenter(s,i,i)
            #even
            if i != n-1 and s[i]==s[i+1]:
                self.extendAroundCenter(s,i,i+1)
        return s[self.start:self.end+1]
            
    def extendAroundCenter(self,s,l,r):
        while l>=0 and r<len(s) and s[l]==s[r]:
            l-=1
            r+=1
        l+=1
        r-=1
        if self.maxL<r-l+1:
            self.maxL = r -l + 1
            self.start = l
            self.end = r
            
        
            
            
        






"""TC = O(n^2)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == None:
            return s
        dp = [[False for _ in range(len(s))] for _ in range(len(s))]
        print(dp)
        maxL = 0
        start = 0
        end = 0
        for i in range(len(s)):
            for j in range(i+1):
                if (s[i]==s[j]) and (i-j<=2 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if maxL<i-j+1:
                        maxL = i-j+1
                        start  = j
                        end = i
        return s[start:end+1]"""
        