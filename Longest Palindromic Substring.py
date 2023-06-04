# Time Complexity :  O(n^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        reslen = 0
        i = 0
        for i in range(len(s)):
            l,r = i,i
            while l >=0 and r < len(s):
                if s[l] == s[r]:
                    if (r-l+1) > reslen:
                        reslen = r-l+1
                        res = s[l:r+1]
                else:
                    break
                l-=1
                r+=1
            l,r = i,i+1
            while l >=0 and r < len(s):
                if s[l] == s[r]:
                    if (r-l+1) > reslen:
                        reslen = r-l+1
                        res = s[l:r+1]
                else:
                    break
                l-=1
                r+=1
        return res
             