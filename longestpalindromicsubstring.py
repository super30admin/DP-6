# Time Complexity: O(n^2)
# Space Complexity: O(1)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        self.max_length = 0
        self.start = self.end = 0

        def helper(self, s, left, right):
            while left >= 0 and right < n and s[left] == s[right]:
                left -= 1
                right += 1
            left += 1
            right -= 1

            if self.max_length < right - left + 1:
                self.max_length = right - left + 1
                self.start = left
                self.end = right
            return self.max_length

        for i in range(n):
            helper(self, s, i, i)
            if i < n - 1 and s[i] == s[i + 1]:
                helper(self, s, i, i + 1)

        return s[self.start:self.end + 1]