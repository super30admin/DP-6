"""longest pallindrome substring
dpmatrix = [[0 for x in range(amount + 1)] for y in range(len(coins) + 1)]"""

#
# class Solution:
#
#     def longestPalindrome(self, s: str) -> str:
#         self.start = 0
#         self.end = 0
#         # n=len(s)
#         n = len(s)
#         if n == 0:
#             return s
#         for i in range(n):
#             self.extendaroundcenter(s, i, i)  ###for odd length
#             if i < n - 1 and s[i] == s[i + 1]:
#                 self.extendaroundcenter(s, i, i + 1)
#         return s[self.start:self.end + 1]
#
#     def extendaroundcenter(self, string, left, right):
#         while left > -1 and right < len(string) and string[left] == string[right]:
#             left -= 1
#             right += 1
#             ####now see left has gone one step lefter and right has gone one step righter and the string is one stap back so we do
#         left += 1
#         right -= 1
#
#         if right - left > self.end - self.start:
#             self.start = left
#             self.end = right

#             return string[self.start:end+1]


#         i=0
#         j=0
#         n=len(s)
#         start=0
#         end=0
#         dp=[[False for x in range(n)] for y in range(n)]
#         # print(dp)
#         for i in range(n):
#             for j in range(i+1):
#                 ##if the characters are same then definitely we proceed forward to check the substrings in between like
#                 ###aba we only proceed if both the a's on extremens are same
#                 if s[i]==s[j] and (i-j<2 or dp[i-1][j+1]):
#                     dp[i][j]=True
#                     if i-j> end-start:
#                         start=j
#                         end=i
#         return s[start:end+1]


class Solution:
    def longestPalindrome(self, s: str) -> str:

        i = 0
        j = 0
        n = len(s)
        start = 0
        end = 0
        dp = [[False for x in range(n)] for y in range(n)]
        # print(dp)
        for i in range(n):
            for j in range(i + 1):
                ##if the characters are same then definitely we proceed forward to check the substrings in between like
                ###aba we only proceed if both the a's on extremens are same
                if s[i] == s[j] and (i - j < 2 or dp[i - 1][j + 1]):
                    dp[i][j] = True
                    if i - j > end - start:
                        start = j
                        end = i
        return s[start:end + 1]

        ###if the chracters are not same

        ###palindrome check within substring


