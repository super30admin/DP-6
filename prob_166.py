# Leetcode 5
# space- 0(n*n) -- matrix size
# passed in leetcode
# brute force: Iterate throught the word with i,j pointer and find if its is palindrome --  o(n3)-- including checking palindrome
# algo : We create a dp matrix for every possible palindrome as shown in the for loop below, if the cheking palindrome lenght is <=3, then we can only chekc for the ending elements and tell it that substring is palindrome or not, else we check for the subsutring between i and j already present in DP matrix
class Solution:
    def longestPalindrome(self, s: str) -> str:
        # base case if s == null or s is empty
        if not (s):
            return ""
        # intialise and create dp matrix
        dp = [[False for i in range(len(s))] for i in range(len(s))]
        end = 0
        start = 0
        # traverse through matrix and checl for palindrome
        for i in range(len(
                s)):  # for every value of i we check the palindrome combinations from the end of the string from i to 0 and update in matrix
            for j in range(i, -1, -1):
                if s[i] == s[j] and (i - j <= 2 or dp[i - 1][
                    j + 1]):  # to check if remaining part of string is palindrome, we check dp[i-1][j+1] is True
                    dp[i][j] = True
                    if (i - j) > end - start:
                        start = j
                        end = i
        return s[start:end + 1]

        # check for 2 cases if char at i and j match

