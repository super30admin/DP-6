"""
time : o(n^2)
space : o(1)

"""
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if not s:
            return ""
        
        self.start = 0 #start of the resultant palindrome
        self.max_len = 0 # length
        
        for i in range(len(s)):
            self.expand(s,i,i) #expand from center at each index to find the palindromic string
            
            if i < len(s) - 1 and s[i + 1] == s[i]: #if the next element is same as the current, there is a possibility of even lenght string
                self.expand(s,i,i+1)
            
        return s[self.start : self.start + self.max_len ]
    
    def expand(self,s,left,right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
            
        if right - left - 1 > self.max_len: #compare current length with the max length till now
            self.max_len =  right - left - 1
            self.start = left + 1 #update start of the palindrome
        