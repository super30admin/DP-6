#Time complexity : O(n^2)
#Space complexity: O(1)
#Works on leetcode : yes
#Approach : We iterate through each character of input string and using a helper function check for palindrome. We use the 
# helper function twice - one with start and end as ith position of string and another as ith position as start and (i+1)th 
# position as end (for case of even palindrome). The helper function helps us find the palindromic substrings using which
# we get the longest palindrome. 

class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        res = ""
        for i in range(len(s)):
            temp = self.helper(s,i,i)
            if len(temp)>len(res):
                res = temp
            temp = self.helper(s,i,i+1)
            if len(temp)>len(res):
                res = temp
        return res
    
    def helper(self,s,l,r):
        while l>=0 and r<len(s) and s[l]==s[r]:
            l-=1
            r+=1
        return s[l+1:r]