class Solution:
    
    """
    Description: Find the longest palindromic substring in a given string s
    
    Time Complexity: O(n^2) for both solutions
    Space Complexity: O(n^2) for DP solution, O(1) for two-pointers
    where n is length of the given string
    
    Approach: using DP matrix
    1. Initiate a DP matrix with n x n size (fill with boolean False)
    2. iterate through the string and at every index, iterate from the begining to apply the following:
       - if the character is same and previous substring is found to be a palindrome (from previous sub problem), replace dp value to True
       - if character is same and difference of indices is less than 2, replace dp value to True
    3. store a maximum length parameter and update and store the start and end indices
    4. return the substring using #3
    
    Approach: Optimized (using two-pointers)
    1. for each character extend the indices until palindrome exist
       - update the maximum length if get better outcome
       - special precaution for odd number of strings (starting indices needs to be on the character and the next)
    2. maintain a starting index and return substring using start index and the maximum length
    """

    def longestPalindrome(self, s: str) -> str:
        
        n = len(s)
        str_idx = 0; end_idx = 0
        maxLen = 0
        
        for i in range(n):
            if i < n - 1 and s[i] == s[i + 1]:
                left = i; right = i + 1
            else: left = i; right = i
            
            while left >=0 and right < n and s[left] == s[right]:
                left -= 1; right += 1
                if maxLen < right - left - 1:
                    maxLen = right - left - 1
                    str_idx = left + 1
                
        return s[str_idx: str_idx + maxLen]

                    
    def longestPalindrome(self, s: str) -> str:
        
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        dp[0][0] = True; maxLen = 0
        str_idx = 0; end_idx = 0
        
        for i in range(n):
            for j in range(i):
                if s[i] == s[j] and (i - j <= 2 or dp[i - 1][j + 1]):
                    dp[i][j] = True
                    if maxLen < i - j + 1:
                        maxLen = i - j + 1
                        str_idx = j; end_idx = i
                    if maxLen == n: break
                        
        return s[str_idx: end_idx + 1]
