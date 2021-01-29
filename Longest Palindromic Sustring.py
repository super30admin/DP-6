# Time:- O(n^2)
# Space:- O(1)
# Approach:- We expand around the center using two pointers a palindrome if it is of even length
# can have the center 2 elements same or if it is of odd length can have a center of 1 element.
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        maxlength=0
        self.string=""
        if len(s)==1:
            return s
        def checkpalindrome(i,j):
            # we can keep expanding until s[i] and s[j] are same
            while(i>=0 and j<len(s) and s[i]==s[j]):
                i-=1
                j+=1
            if j-i-1>maxlength:
                self.string=s[i+1:j]
            return j-i-1
        for i in range(len(s)-1):
            # we can have a palindrome of center 1 element or a palindrome of center 2 elements.
            maxlength=max(maxlength,checkpalindrome(i,i),checkpalindrome(i,i+1))
            if maxlength==len(s):
                break
        return self.string
        