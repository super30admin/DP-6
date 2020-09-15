'''
264. Ugly Number II
time complexity - O(N)
space complexity - O(N)
Approach - DP + three pointers approach 

          1) first we maintain i,j,k for 2,3,5 pointers
          2) next we have to calculate the minimum of (2*dp[i],3*dp[j],5*dp[k])
          3) if suppose minimum comes from 2*dp[i] then we increment i+=1
          4) if minimum comes from 2 and 3 then we increment both i and j pointer # example 6
          
'''
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res=[1]
        i=j=k=0
        cnt=0
        
        while cnt<n:
            val=min(2*res[i],min(3*res[j],5*res[k]))
            if val==res[i]*2:
                i+=1
            if val==res[j]*3:
                j+=1
            if val==res[k]*5:
                k+=1
            cnt+=1
            
            if cnt==n:
                return res[-1]
            res.append(val)