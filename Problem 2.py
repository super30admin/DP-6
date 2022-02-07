# Time: O(n*n*n)
# Space: O(1)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        #print(s[::-1])
        ln = 1
        ans = s[0]
        for i in range(len(s)):
            for j in range(i+ln, len(s)):
                temp = s[i:j+1]
                if temp == temp[::-1]:
                    if ln < len(temp):
                        ln = max(ln, len(temp))
                        ans = temp
        return ans

# Time: O(n*n)
# Space: O(1)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        mx = 1
        pal = s[0]
        for ind in range(0, len(s)-1):
            i = ind - 1
            j = ind + 1
            # Checking odd length palindrome
            while i >=0 and j < len(s) and s[i] == s[j]:
                if mx < j-i+1:
                    mx = j-i+1
                    pal = s[i:j+1]
                i -=1
                j += 1
            # Checking even length palindrome if possible
            if s[ind] == s[ind+1]:
                if mx < 2:
                    mx = 2
                    pal = s[ind:ind+2]
                i = ind - 1
                j = ind + 2
                while i >=0 and j < len(s) and s[i] == s[j]:
                    if mx < j-i+1:
                        mx = j-i+1
                        pal = s[i:j+1]
                    i -=1
                    j += 1
        return pal
 # DP Approach
# Time: O(n*n)
# Space: O(n*n)
# Time: O(n*n)
# Space: O(n*n)
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        dp = [[False for x in range(len(s))] for y in range(len(s))]
        mx = -1
        ans = ''
        for i in range(len(s)):
            for j in range(i+1):
                if s[i] == s[j]:
                    if i-j <=2 or dp[i-1][j+1] == True:
                        dp[i][j] = True
                        if mx < i-j+1:
                            mx = i-j+1
                            ans = s[j:i+1]

        #print(dp)
        #print(mx)
        return ans
                
        
        
