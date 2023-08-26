# Time Complexity : O(n^2)
# Space Complexity : O(n)

# Code ran on LeetCode
# At each index, consider odd length and even length palindromes separately. Initialize left and right pointers and keep updating them until we can form a palindrome and update result if longer palindrome is seen

class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        n = len(s)
        res = ''
        for i in range(n):
            # Odd length
            l = i; r = i
            while l >= 0 and r < n and s[l] == s[r]:
                if (r - l + 1) > len(res):
                    res = s[l:r+1]
                l -= 1; r+=1
            # Even length
            l = i; r = i+1
            while l >= 0 and r < n and s[l] == s[r]:
                if r - l + 1 > len(res):
                    res = s[l:r+1]
                l -= 1; r += 1
        return res

        # # DP 
        # n = len(s); start = end = 0
        # dp = [[False]*n for _ in range(n)]
        # res = ''
        # for i in range(n):
        #     # print(res)
        #     for j in range(i+1):
        #         if s[i] == s[j]:
        #             if i - j <= 2 or dp[i-1][j+1]:
        #                 dp[i][j] = True
        #                 if i-j > end - start:
        #                     start = j; end = i
        # return s[start:end+1]

