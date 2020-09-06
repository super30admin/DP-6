class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s==None or len(s)==0:
            return s
        dp=[[False]*len(s)]*len(s)
        
        start=0
        end=0
        for i in range(len(dp)):
            for j in range(i,-1,-1):
                if s[i]==s[j] and (i-j<2 or dp[i-1][j+1]):
                    dp[i][j]=True
                    if end-start<i-j:
                        start=j
                        end=i
        return s[start:end+1]
        
#Time complexity is O(n2)
#Space complexity is O(n2)
