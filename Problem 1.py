class Solution:
    def longestPalindrome(self, s: str) -> str:
        
        def findMaxPalindromeFromThisPoint(point):
            l = r = point
            while l >= 0 and r < len(s):
                if s[l] == s[r]:
                    l -= 1
                    r += 1
                else:
                    break
            
            return s[l+1:r]
           
        def findMaxPalindromeFromThisPointForEven(point):
            l = point
            r = point + 1
            while l >= 0 and r < len(s):
                if s[l] == s[r]:
                    l -= 1
                    r += 1
                else:
                    break
            
            return s[l+1:r]
        
        
        max_palindrome1 = ""
        for centre in range(len(s)):
            res = findMaxPalindromeFromThisPoint(centre)
            # print(res)
            if len(res) > len(max_palindrome1):
                max_palindrome1 = res
        
        
        max_palindrome2 = ""
        for centre in range(len(s)):
            res = findMaxPalindromeFromThisPointForEven(centre)
            # print(res)
            if len(res) > len(max_palindrome2):
                max_palindrome2 = res
        
        return max_palindrome1 if len(max_palindrome1) > len(max_palindrome2) else max_palindrome2
