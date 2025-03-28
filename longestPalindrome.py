class Solution:
    # TC :O(n**2)
    # SC: O(1)
    def longestPalindrome(self, s: str) -> str:
        def expandovercenter(l,r):
            while l>=0 and r<len(s) and s[l]==s[r]:
                r+=1
                l-=1
            return s[l+1:r]
        longestp = s[0]
        for i in range(len(s)-1):
            oddlenp = expandovercenter(i,i)
            evenlenp = expandovercenter(i,i+1)
            if len(oddlenp) > len(longestp):
                longestp = oddlenp
            if len(evenlenp) > len(longestp):
                longestp = evenlenp
        return longestp
        