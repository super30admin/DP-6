#Longest palindromic substring

# // Time Complexity : O(N^2)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def longestPalindrome(self, s: str) -> str:
        if len(s)==1:return s
        def palin(s,l,r):                                       #returns the longest string if the given value is a palindome
            while (l>=0 and r<=len(s)-1 and s[l]==s[r]):
                l-=1
                r+=1
            return s[l+1:r]
        res=""
        for i in range(len(s)):                             #for every substring, find if it is an odd or even palindrome
            odd=palin(s, i, i)
            even = palin(s,i,i+1)
            longest= max(odd, even, key=len)
            res=max(longest,res, key=len)
        return res
        
        