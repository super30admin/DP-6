# Time Complexity : O(n**2)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def longestPalindrome(self, s: str) -> str:
        res_l =0
        res_r = 0
        max_len = 0

        for i in range(len(s)):
            l,r = i,i
            print(l,r)
            while (l >= 0 and r < len(s)) and s[l] == s[r]:
                if r-l+1 > max_len:
                    max_len = r-l+1
                    res_l =l
                    res_r = r
                l -= 1
                r += 1
    

            l,r = i,i+1
            print(l,r)
            while (l >= 0 and r < len(s)) and s[l] == s[r]:
                if r-l+1 > max_len:
                    max_len = r-l+1
                    res_l =l
                    res_r = r
                l -= 1
                r += 1  

        return s[res_l:res_r+1]