#All TC passed on leetcode


class Solution:
    def longestPalindrome(self, s: str) -> str:

        #Here we use 2 pointer approach. We iterate through the string for each char we check char 
        #on either side are equal or not.
        #time complexity - O(n^2)
        #space complexity - O(1)
        start = 0
        end = 0
        for i in range(len(s)):
            low = i-1
            high = i+1
            l, h = self.check(s, low, high)
            if h-l>end-start:
                start = l
                end = h

            low = i
            high = i+1
            l, h = self.check(s, low, high)
            if h-l>end-start:
                start = l
                end = h
        
        return s[start:end+1]


    def check(self, s, l, h):
        n = len(s)
        while l>=0 and h<n and s[l]==s[h]:
            l-=1
            h+=1
        l+=1
        h-=1
        return l, h


#-------------------------------------------------OR--------------------------------------------------
        
        
        #Here we use dp approach. We compare string chars from front and back 
        #time complexity - O(n^2)
        #space complexity - O(n^2)
        n = len(s)
        dp = [[False]*n for i in range(n)]
        start = 0
        end = 0

        for i in range(n):
            for j in range(i+1):
                if (s[i]==s[j]) and (i-j<2 or dp[i-1][j+1]):
                    dp[i][j] = True
                    if i-j>end-start:
                        start = j
                        end = i 
                else:
                    dp[i][j] = False
        return s[start:end+1]

        