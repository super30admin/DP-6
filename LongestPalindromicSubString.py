'''
Solution:
1.  First solution is using DP, where a cell (i, j) is true if cell (i+1, j-1) meaning substring from index i+1 to j-1
    is a palindrome and s[i] == s[j]. Also, we keep track of max length substring which is a palindrome while filling
    the cells
2.  Second solution is using 2 pointers, where we start from the middle index(indices) and iterate towards extremes
    until the substring is a palindrome. Here also, we keep track of max length substring which is a palindrome while
    moving towards extremes.

Time Complexity:    O(N^2) for both
Space Complexity:   O(N^2) using DP and O(1) using 2 pointers

--- Passed all testcases successfully for both the solutions on leetcode.
'''


class LongestPalindromeDP(object):
    def longestPalindrome(self, s: str) -> str:
        """
        :type s: str
        :rtype: str
        """
        #   edge case check
        if (s == None or len(s) == 0):
            return ''

        #   initializations
        n = len(s)
        subProblems = [[False for i in range(n)] for j in range(n)]

        #   for length 1 substrings
        length = 1
        for i in range(n - length + 1):
            j = i + length - 1
            subProblems[i][j] = True

        start = 0
        end = 0

        #   for length 2 substrings
        length = 2
        for i in range(n - length + 1):
            j = i + length - 1
            if s[i] == s[j]:
                subProblems[i][j] = True
                start = i
                end = j

        #   for length 3 to n substrings
        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1

                #   true if substring i+1 to j-1 is palindrome and s[i] == s[j]
                if (subProblems[i + 1][j - 1] == True and s[i] == s[j]):
                    subProblems[i][j] = True
                    start = i
                    end = j

        #   return the substring
        return s[start: end + 1]


class LongestPalindromePointers:

    def __init__(self):
        self.start = 0
        self.maxLen = 0

    def __getLongestFromMiddle(self, s: str, left: int, right: int) -> None:

        #   this function goes to left and right ends until where substring is a palindrome
        while (left >= 0 and right < len(s) and s[left] == s[right]):
            left -= 1
            right += 1

        left += 1
        right -= 1

        currentLength = right - left + 1

        #   update globals
        if (currentLength > self.maxLen):
            self.start = left
            self.maxLen = currentLength

        return

    def longestPalindrome(self, s: str) -> str:

        #   edge case checks
        if (s == None or len(s) < 2):
            return s

        #   for odd length and even lengths starting from an index in the middle
        for middle in range(len(s)):
            self.__getLongestFromMiddle(s, middle, middle)
            self.__getLongestFromMiddle(s, middle, middle + 1)

        #   return max substring which is palindrome
        return s[self.start: self.start + self.maxLen]