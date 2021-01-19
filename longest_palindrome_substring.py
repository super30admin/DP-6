class Solution:
    def longestPalindrome(self, s: str) -> str:
    #### DP  ##########
    ## Time- O(n**2)
    ## space- O(n**2)
    #         dp=[[False for i in range(len(s))] for i in range(len(s))]
    #         maxx=1
    #         res=s[0]
    #         dp[0][0]=True
    #         for i in range(len(s)):
    #             for j in range(i+1):
    #                 if s[i]==s[j] and (i-j<2 or dp[i-1][j+1]==True):
    #                     dp[i][j]=True
    #                     if i-j+1>maxx:
    #                         maxx=i-j+1
    #                         res=s[j:i+1]
    #         return res


    ## time - o(n**2) --> n for checking palindrome and n for iteratign
    ##space - O(1)
        def palindrone(s, high, low):
            while low < len(s) and high >= 0 and s[high] == s[low]:
                high -= 1
                low += 1
            return low - high - 1


        start = end = 0
        for i in range(len(s) - 1):
            x = palindrone(s, i, i)
            y = palindrone(s, i, i + 1)
            maxx = max(x, y)
            if maxx > end - start:
                start = i - (maxx - 1) // 2
                end = i + (maxx) // 2
        return s[start:end + 1]
