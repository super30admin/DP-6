'''
leet code - 5. Longest Palindromic Substring
Time complexity - O(N)
space cmplexity - O(N)

Approach - DP 1) first i goes from 0 to len(s), where as j goes from i to -1,-1
              2) if i-j<=2 or s[i]==s[j] then dp[i][j]=True # for bab, aba, a,b etc
              3) id i- j>=2 or s[i]==s[j] then substring must be palindrome that is dp[i-1][j+1] is true
              4) if i-j>end-start then we change start and end
              4) In the end substring of s[start-end+1]
'''
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s: return ""
            
        n=len(s)
        dp =[[False for _ in range(n)] for _ in range(n)]
        
        
        start=0
        end=0
        
        for i in range(0,n,1):
            for j in range(i,-1,-1):
                
                if (s[i]==s[j] and (i-j<=2))  or(s[i]==s[j] and   dp[i-1][j+1]==True):
                    
                    dp[i][j]=True
                    if (i-j>end-start):
                        start=j
                        end=i
                        
                  
        return s[start:end+1]       
                