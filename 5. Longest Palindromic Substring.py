#time: O(n^2)
#space:O(1)
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n= len(s)

        self.mx=1
        self.mw=s[0]
        def expand(l,r):
            while l>=0 and r<n and s[l]== s[r]:
                l-=1
                r+=1
            l+=1
            r-=1
            if r-l+1 >self.mx:
                self.mx= r-l+1
                self.mw= s[l:r+1]
        for i in range(len(s)):
            expand(i,i)
            if i < n-1:
                expand(i,i+1)
        return self.mw
