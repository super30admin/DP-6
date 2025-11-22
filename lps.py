# Time Complexity : O(N^2) where N is the length of the string
# Space Complexity : O(1) as we are using only constant extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using the expand around center technique to find the longest palindromic substring.
# For each character in the string, I consider it as the center of a potential palindrome.
# I expand outwards to check for odd-length palindromes by comparing characters on both sides.
# I also check for even-length palindromes by considering the gap between the current character
# and the next character as the center.
# I keep track of the maximum length palindrome found and update the result accordingly.


class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        maxy = 0
        result = ""
        
        for i in range(n):
            j = i - 1
            k = i + 1
            while j >= 0 and k < n and s[j] == s[k]:
                if k - j + 1 > maxy:
                    maxy = k - j + 1
                    result = s[j:k+1]
                j -= 1
                k += 1
            j = i
            k = i + 1
            while j >= 0 and k < n and s[j] == s[k]:
                if k - j + 1 > maxy:
                    maxy = k - j + 1
                    result = s[j:k+1]
                j -= 1
                k += 1
        return result or s[0]