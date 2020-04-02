class Solution:
    def longestPalindrome(self, s: str) -> str:
        """
            https://leetcode.com/problems/longest-palindromic-substring/
            Time Complexity - O(n^2)
            Space Complexity - O(n)
        """
        dp = [[False for _ in range(len(s))] for _ in range(len(s))]
        start = end = 0

        for i in range(len(s)):
            for j in reversed(range(0, i + 1)):
                print(i, ' ', j)
                if s[i] == s[j] and (i - j <= 2 or dp[i - 1][j + 1]):
                    dp[i][j] = True
                    if end - start < i - j:
                        start = j
                        end = i
        return s[start:end + 1]

    def longestPalindrome(self, s):
        """
            https://leetcode.com/problems/longest-palindromic-substring/
            Time Complexity - O(n^2)
            Space Complexity - O(1)
            Three line Explanation-
                - For each char in the string
                    - Expand the char for odd and even case palindrome
                      to form a new string
                    - Find max between result, odd_string, even_string
        """
        self.max_len = self.start = 0
        for c in range(len(s)):  # O(n)
            # expanding for odd case, like 'aba' in 'babad'
            self._helper(s, c - 1, c + 1)  # O(n)
            # expanding for even case, like 'adda' in 'baddad'
            self._helper(s, c, c + 1)  # O(n)
        return s[self.start:self.start + self.max_len]

    def _helper(self, s, left, right):
        """
            left , right: the start position to expand
        """
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        # 'aba' left = -1 right = 3 (left and right both are off by 1)
        # right - (left + 1) = 3 - (-1 + 1) = 3
        if right - (left + 1) > self.max_len:
            self.max_len = right - (left + 1)
            self.start = left + 1


if __name__ == '__main__':
    print(Solution().longestPalindrome('babad'))
