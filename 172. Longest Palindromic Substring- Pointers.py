class Solution:
    n = 0
    start = 0
    end = 0

    def longestPalindrome(self, s: str) -> str:
        if s is None or len(s) == 0:
            return s
        self.n = len(s)
        self.start = 0
        self.end = 0

        for i in range(self.n):
            self.extendAroundCenter(s, i, i)
            if i < self.n - 1 and s[i] == s[i + 1]:
                self.extendAroundCenter(s, i, i + 1)
        print(self.start, self.end)
        return s[self.start: self.end + 1]

    def extendAroundCenter(self, s, left, right):
        while left >= 0 and right < self.n and s[left] == s[right]:
            left -= 1
            right += 1

        left += 1
        right -= 1

        if (right - left) > (self.end - self.start):
            self.start = left
            self.end = right

# Pointers
# Time Complexity: O(n^2)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
