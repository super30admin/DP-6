"""
TC and SC O(N^2)

Dp solution : we have repeated subproblem of substrings that classified as a palindrome or not.


"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:
            return s
        n=len(s)
        dp=[[False for i in range(n)] for j in range(n)]
        maxi1=1
        start,end=0,0
        for i in range(n):
            for j in range(i+1):
                if s[i]==s[j] and (i-j<=2 or dp[i-1][j+1]):
                    dp[i][j]=True
                    if maxi1<(i-j+1):
                        maxi1=i-j+1
                        start=j
                        end=i
        return s[start:end+1]
        