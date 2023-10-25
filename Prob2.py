class Solution:
    def longestPalindrome(self, s: str) -> str:
        #method 1 - create all possible substrings (o(n^2)) and check if each is a pali -> total TC O(n^3)

        #Mthod 2 - expand from curr character in both directions - TC O(n^2)
        # start=end=0
        # def extendedaround(s,left,right):
        #     nonlocal start,end
        #     while left>=0 and right<len(s) and s[left]==s[right]:
        #         left-=1
        #         right+=1
        #     left+=1 #after the while, they will be 1 index off so set left and right back to correct positions
        #     right-=1
        #     if right-left>end-start:
        #         start=left
        #         end=right
        # n=len(s)
        # for i in range(n):
        #     extendedaround(s,i,i) #odd length palindrome check keep left and right as i itself and expadn outwards
        #     if i<n-1 and s[i]==s[i+1]: #even length palidrome check only possible when curr char is equal to next char
        #         extendedaround(s,i,i+1) #so, keep left as curr and right as curr+1
        
        # return s[start:end+1]

        #Method 3 - DP -> O(n^2)
        #In method 1 - if you observe there were repeated sub problems -> zbabz, when you start at 0 and check all possible palindromes, you will find zbabz is a palindrome, that means bab is also a palindrome, but when you come to 1, you will again check if bab is a palindrome -> DP 

        n=len(s)
        dp=[[False for _ in range(n)]for _ in range(n)]
        start=end=0

        for i in range(len(s)):
            for j in range(i+1):
                if s[i]==s[j]:
                    if i-j<2 or dp[i-1][j+1]: #i-j case is a DP adjustment, write out the matrix you'll get it.
                    #dp[i-1][j+1] this is essentially looking at previously checked inner characsters if they were a palindome or not
                        dp[i][j]=True
                        if i-j>end-start:
                            start=j
                            end=i
                    else:
                        dp[i][j]=False
                else:
                    dp[i][j]=False
        return s[start:end+1]
        


