# Time complexity : O(n*n)
# Space complexity : O(n*n)
# Leetcode : Solved and submitted

class Solution:
    def longestPalindrome(self, s: str) -> str:
        # find length of the string
        n = len(s)
        
        # create a 2-d dp boolean array
        dp = [[False for _ in range(n)] for _ in range(n)]
        
        # default values for start and end pointers
        start, end = 0, 0
        
        # traverse through the matrix of dp
        for i in range(n):
            for j in range(i+1):
                # if the characters match and the difference is less than 2, also the previous chars are palindrome, then update this as palindrome
                if s[i] == s[j] and ((i-j) < 2 or dp[i-1][j+1] == True):
                    dp[i][j] = True
                    
                    # if the current difference of length is greater than earlier one, then update the start and end pointer
                    if i - j > end - start:
                        start = j
                        end = i
        
        # return the string from start till the end + 1
        return s[start:end+1]
