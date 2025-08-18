# class Solution:
#     def longestPalindrome(self, s: str) -> str:
#         n = len(s)
#         maxlen = 0
#         start = 0
#         end = 0
#         dp = [[False]*n for _ in range(n)]
#         for i in range(n):
#             for j in range(i+1):
#                 if s[i] == s[j]:
#                     if (i-j)<=1 or dp[i-1][j+1]:
#                         dp[i][j] = True
#                         if maxlen<(i-j+1):
#                             maxlen = i-j+1
#                             start = j
#                             end = i
#                     else:
#                         dp[i][j] = False
#                 else:
#                     dp[i][j] = False
#         return s[start: end+1]

class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        maxlen = 0
        start = 0
        end = 0
        dp = [False]*n
        for i in range(n):
            for j in range(i+1):
                if s[i] == s[j]:
                    if (i-j)<=1 or dp[j+1]:
                        dp[j] = True
                        if maxlen<(i-j+1):
                            maxlen = i-j+1
                            start = j
                            end = i
                    else:
                        dp[j] = False
                else:
                    dp[j] = False
        return s[start: end+1]
        
# class Solution:
#     def longestPalindrome(self, s: str) -> str:
#         self.start = 0
#         self.end = 0
#         self.maxlen = 0
#         self.n = len(s)
#         def extendpath(l,r):
#             while l>=0 and r<self.n and s[l] == s[r]:
#                 l-=1
#                 r+=1
#             l+=1
#             r-=1
#             if self.maxlen<r-l+1:
#                 self.maxlen =r-l+1
#                 self.start = l
#                 self.end = r
            
#         for i in range(self.n):
#             extendpath(i,i)
#             if i<self.n-1 and  s[i]==s[i+1]:
#                 extendpath(i,i+1)
#         return s[self.start:self.end+1]
        