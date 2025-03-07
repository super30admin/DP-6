"""
TC: O(n*n)
SP:O(1)
expand around the center for both odd and even length cases
"""
class Solution:
    def longestPalindrome(self, s: str) -> str:
        def countPalindrome(l, r):
            while l >= 0 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1

            return r - l - 1

        res = [0, 0]
        for i in range(len(s)):
            odd = countPalindrome(i, i)
            even = countPalindrome(i, i + 1)
            if odd > res[1] - res[0] + 1:
                dist = odd // 2
                res = [i - dist, i + dist]
            if even > res[1] - res[0] + 1:
                dist = even // 2 - 1
                res = [i - dist, i + dist + 1]

        return s[res[0] : res[1] + 1]
