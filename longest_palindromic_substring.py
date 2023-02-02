class Solution:
    def longestPalindrome(self, s: str) -> str:

        ## apporach 2
        ## T.C = O(n.n)
        ## S.C = O(1)
        n = len(s)
        start = 0
        end = 0
        mx = 0
        def expand_around_center(l, r):
            nonlocal mx, start, end
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
            l += 1
            r -= 1
            if mx < r - l + 1:
                mx = r - l + 1
                start = l
                end = r

        for i in range(n):
            expand_around_center(i, i)
            expand_around_center(i, i+1)
            
        return s[start: end + 1]


        ## approach 1 : dp
        ## T.C = O(n.n)
        ## S.C = O(n.n)
        n = len(s)
        dp = [ [False]*n for i in range(n)]
        mx = 0
        start = 0
        end = 0

        for i in range(0,n):
            for j in range(0,i+1):
                if s[j] == s[i] and ((i - j - 1) <= 1 or dp[i-1][j+1]== True):
                    dp[i][j] = True
                    if mx < (i - j + 1):
                        mx = i - j + 1
                        start = j
                        end = i
        return s[start: end + 1]
