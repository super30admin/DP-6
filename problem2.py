# problem 2
#https://leetcode.com/problems/longest-palindromic-substring/description/

class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        max_len = 0 
        start = 0 
        end = 0 

        dp_arr = [[False]*n for _ in range(n)]

        for i in range(n):
            for j in range(i+1):
                if s[i] == s[j]:
                    if i-j<=1 or dp_arr[i-1][j+1]:
                        dp_arr[i][j] = True 
                        if max_len < i-j+1:
                            max_len = i-j+1
                            start = j
                            end = i 
                    else:
                        dp_arr[i][j] = False  
                else:
                    dp_arr[i][j] = False 
        return s[start:end+1]