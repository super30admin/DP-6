# Time Complexity : O(n^2) [n = length of string s]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s:return ""
        
        def check_palindrome(start, end):
            while start >= 0 and end < len(s) and s[start] == s[end]:
                start-=1
                end+=1
            
            return (start+1, end-1)
        max_len = 1
        lps_start, lps_end = 0, 0
        for i in range(len(s)):
            
            # case odd
            curr_start, curr_end = check_palindrome(i,i)
            if curr_end - curr_start >  lps_end - lps_start:
                lps_start = curr_start
                lps_end = curr_end
            # case even
            if i < len(s) -1:
                curr_start, curr_end = check_palindrome(i, i+1)
                if curr_end - curr_start >  lps_end - lps_start:
                    lps_start = curr_start
                    lps_end = curr_end
                
        return s[lps_start:lps_end+1]
