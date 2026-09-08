# Problem2: (https://leetcode.com/problems/longest-palindromic-substring/)
# Time Complexity: O(n^2),n centers to try, each expansion can walk up to O(n) steps (worst case: string of all identical characters, e.g. "aaaa").
# Space Complexity: O(1), Only a constant number of tracking variables are used.the returned slice is the output, not extra working space.
# Approach:
# For every index, treat it as the center of a palindrome and expand outward in both directions. 
#Try two center types per index:
#  odd length: single character center (left == right)
#   even length: two-character center (left, left+1)
# Track the longest match seen across all centers.

class Solution:
    def __init__(self):
        self.max = 0
        self.start = 0
        self.end = 0

    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        self.max = 0
        self.start = 0
        self.end = 0

        for i in range(n):
            self.expandaround(s, i, i)      # try odd-length center at i

            # only try even-length center if i+1 is in bounds
            # and the two middle characters actually match
            if i < n - 1 and s[i] == s[i + 1]:
                self.expandaround(s, i, i + 1)  # try even-length center at i, i+1

        return s[self.start:self.end + 1]  # +1 because slicing excludes the end index

    def expandaround(self, s: str, left: int, right: int):
        # grow outward while both pointers are in bounds and characters match
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1

        # last step went one too far (out of bounds or mismatch), so step back in
        left += 1
        right -= 1

        # update the best result if this palindrome is longer than the current max
        if self.max < right - left + 1:
            self.max = right - left + 1
            self.start = left
            self.end = right