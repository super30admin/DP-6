# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Expand around center technique.
# For each index treat it as center of odd length palindrome and even length palindrome.
# Expand outward while characters match.

class Solution:
    def longestPalindrome(self, s: str) -> str:
        resLen = 0
        result = ""
        for i in range(len(s)):
            l = i
            r = i
            while l>=0 and r<len(s) and s[l] == s[r]:
                if resLen < r-l+1:
                    result = s[l:r+1]
                    resLen = r-l+1
                l -=1
                r += 1
            l = i
            r = i+1
            while l>=0 and r<len(s) and s[l] == s[r]:
                if resLen < r-l+1:
                    result = s[l:r+1]
                    resLen = r-l+1
                l -=1
                r += 1
        return result
            




        