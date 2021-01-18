#Dp solution
#Time: O(n^2)
#Space: O(n^2)

class Solution:
    def longestPalindrome(self, s: str) -> str:
        """
        :type s: str
        :rtype: str
        """
        
        if (s == None or len(s) == 0):
            return ''

        
        n = len(s)
        dp = [[False for i in range(n)] for j in range(n)]

        #for substrings of length 1
        length = 1
        for i in range(n - length + 1):
            j = i + length - 1
            dp[i][j] = True

        start = 0
        end = 0

       
        length = 2
        for i in range(n - length + 1):
            j = i + length - 1
            if s[i] == s[j]:
                dp[i][j] = True
                start = i
                end = j

        
        for length in range(3, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1

               
                if (dp[i + 1][j - 1] == True and s[i] == s[j]):
                    dp[i][j] = True
                    start = i
                    end = j

       
        return s[start: end + 1]
  
  
  
  # 2 pointers solution
  #Time: O(n^2)
  #Space: O(1)
  
  class Solution:

    def __init__(self):
        self.start = 0
        self.maxLen = 0

    def extendAroundIndex(self, s: str, left: int, right: int) -> None:

      
        while (left >= 0 and right < len(s) and s[left] == s[right]):
            left -= 1
            right += 1

        left += 1
        right -= 1

        currentLength = right - left + 1

      
        if (currentLength > self.maxLen):
            self.start = left
            self.maxLen = currentLength

        return

    def longestPalindrome(self, s: str) -> str:

       
        if (s == None or len(s) < 2):
            return s

      
        for middle in range(len(s)):
            self. extendAroundIndex(s, middle, middle)
            self. extendAroundIndex(s, middle, middle + 1)

       
        return s[self.start: self.start + self.maxLen]
