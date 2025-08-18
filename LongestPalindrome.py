# Time Complexity: O(n^2)
# Space Complexity: O(1)
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
            self.extendsAround(s, i, i)  # odd length
            if i < n - 1 and s[i] == s[i + 1]:
                self.extendsAround(s, i, i + 1)  # even length

        return s[self.start:self.end + 1]

    def extendsAround(self, s: str, left: int, right: int):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1

        left += 1
        right -= 1

        if self.max < right - left + 1:
            self.max = right - left + 1
            self.start = left
            self.end = right
        