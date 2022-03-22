#time-n*n, space n*n
class Solution:
    def longestPalindrome(self, s: str) -> str:
        dp=[[False for i in range(len(s))] for j in range(len(s)) ]
        l=-inf
        start=0
        end=0
        for i in range(len(dp)):
            for j in range(i+1):
                
                if s[i]==s[j] and ((i-j)<2 or dp[i-1][j+1]):
                    dp[i][j]=True
                
                    
                    if i-j>end-start:
                        start=j
                        end=i
            
        return s[start:end+1]
                        
                    
        