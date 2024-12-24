#Time Complexity: The algorithm iterates over each character of the string s as a potential center of a palindrome (for both odd and even lengths). For each center, it expands outward to check for palindromes, which takes O(n) time for each character. Thus, the total time complexity is O(n⋅n)=O(n^2)
#Space Complexity: The algorithm uses only a constant amount of extra space for variables like res, reslen, and indices l and r, resulting in O(1) space complexity.
class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        reslen = 0
        for i in range(0,len(s)):
            #Odd length
            l,r = i,i
            while(l>=0 and r<len(s) and s[l]==s[r]):
                if((r-l+1)>reslen):
                    res = s[l:r+1]
                    reslen = r-l+1
                l-=1
                r+=1
            l,r = i,i+1
            while(l>=0 and r<len(s) and s[l]==s[r]):
                if((r-l+1)>reslen):
                    res = s[l:r+1]
                    reslen = r-l+1
                l-=1
                r+=1
        return res