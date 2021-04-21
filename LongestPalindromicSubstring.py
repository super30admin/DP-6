# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# ExpandAroundCenter works from center and left moves backward and right moves forward to check for palindrome substring until they are same.
# If they are not same, the method returns the substring from the left to right until they were same.
# If the string is of even length then we check if i and i+1 are same. If yes then left is at i and right is at i+1 else both are at i.


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if s == None or len(s) < 2:
            return s
        longest = ""
        for i in range(len(s)):
            len1 = self.expandaroundcenter(s, i, i)
            if len(len1) > len(longest):
                longest = len1
            len2 = self.expandaroundcenter(s, i, i + 1)
            if len(len2) > len(longest):
                longest = len2
        return longest

    def expandaroundcenter(self, s, left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1:right]
