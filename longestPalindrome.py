#TC:O(n^2)
#SC:O(nxn)
#Ran successfully on Leetcode:Yes
#Appraoch:
#1. Create dp array -boolean.
#2. Run two for loops , one through the length of string, another from 0-ith pointer, in reverse order.
#3. Check if the two characters match and if yes, then check if the substring in reverse order match . This can be seen from dp[i-1][j+1]. And also if the substring is less then length 2, then it is only charater, hence append true to dp array.
#4. Every iteration when we see a True case, we update start and end if it is largewr than previous.
#5. Return the substring [start:end+1]
class Solution:
    def longestPalindrome(self, s: str) -> str:
        if not s or len(s)<2:
            return s
        n=len(s)
        dp=[[False]*n for _ in range(n)]
        # print(dp)
        start=0
        end=0
        for i in range(len(dp)):
            for j in (range(i,-1,-1)):
                if s[i]==s[j] and( i-j<2 or dp[i-1][j+1]):
                    dp[i][j]=True
                    if i-j>end-start:
                        start=j
                        end=i
        return s[start:end+1]
                
        
#Second approach using pointers, by expanding the substring
class Solution:
    def longestPalindrome(self, s: str) -> str:
        result = ""
        
        for i in range(len(s)):
           
            word1 = self.checkPalindrome(s, i, i)
            word2 = self.checkPalindrome(s, i, i+1)
            word1 = word1 if len(word1) >= len(word2) else word2 
            result = word1 if len(word1) >= len(result) else result
            
        return result
    
    def checkPalindrome(self, s, l, r):
       
        while l>=0 and r<len(s) and s[l]==s[r]:
            l -= 1
            r += 1
        return s[l+1:r]
