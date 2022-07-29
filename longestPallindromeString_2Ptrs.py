'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on LeetCode: Yes
'''

class Solution:

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