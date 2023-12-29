# Time: O(n^2)
# Space: O(1)
# Did it run on Leetcode: yes

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        # # O(n^2) O(n^2)
        # if(len(s)==0):
        #     return ""
        # n=len(s)
        # end,start=0,0
        # dp=[[False for _ in range(n)]for _ in range(n)]
        # for i in range(n):
        #     for j in range(i+1):
        #         if(s[i]==s[j]):
        #             if(i-j <= 2 or dp[i-1][j+1]):
        #                 dp[i][j]=True
        #                 if(i-j > end-start):
        #                     end=i
        #                     start=j
        # return s[start:end+1]

        # O(n^2) O(n)
        # if(len(s)==0):
        #     return ""
        # n=len(s)
        # end,start=0,0
        # dp=[False for _ in range(n)]
        # for i in range(n):
        #     for j in range(i+1):
        #         if(s[i]==s[j]):
        #             if(i-j <= 2 or dp[j+1]):
        #                 dp[j]=True
        #                 if(i-j > end-start):
        #                     end=i
        #                     start=j
        #             else:
        #                 dp[j]=False
        #         else:
        #             dp[j]=False
        # return s[start:end+1]

        # O(n^2) O(1)
        
        if(len(s)==0):
            return ""
        n=len(s)
        start,end=[0],[0]
        def extendaround(s,l,r):
            
            while(l>=0 and r<len(s) and s[l]==s[r]):
                l-=1
                r+=1
            l+=1
            r-=1
            if(end[0]-start[0] < r-l):
                start[0]=l
                end[0]=r
        for i in range(n-1):
            extendaround(s,i,i)
            if(i!=n and s[i]==s[i+1]):
                extendaround(s,i,i+1)
        return s[start[0]:end[0]+1]