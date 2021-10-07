class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        maxRes = ""
        maxCount = 0
        
        for i in range(len(s)):
            res = ""
            l, r = i, i+1
            while 0 <= l and r < len(s) and s[l] == s[r]:
                res = s[l] + res + s[r]
                l -= 1
                r += 1
            if len(res) > maxCount:
                maxCount = len(res)
                maxRes = res                
        for i in range(len(s)):
            res = s[i]
            l, r = i-1, i+1
            while 0 <= l and r < len(s) and s[l] == s[r]:
                res = s[l] + res + s[r]
                l -= 1
                r += 1
            if len(res) > maxCount:
                maxCount = len(res)
                maxRes = res      
        return maxRes
    
    
    
        