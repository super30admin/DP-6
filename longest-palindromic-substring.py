# TIME COMPLEXITY: O(n^2)
# SPACE COMPLEXITY: O(1)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # Initialize two pointers to track palindromes
        #s = list(s)
        i, left, right = 0, 0, 0
        result = ''

        # Odd Length Palindromes
        for i in range(len(s)):
            left = i
            right = i
            while(left >= 0 and right < len(s) and s[left] == s[right]):
                left -= 1
                right += 1
            if len(result) < len(s[left+1:right]):
                result = s[left+1:right]

        # Even Length palindromes
        for i in range(len(s)):
            left = i
            right = i+1
            while(left >= 0 and right < len(s) and s[left] == s[right]):
                left -= 1
                right += 1
            if len(s[left+1:right]) > len(result):
                result = s[left+1:right]

        return result
