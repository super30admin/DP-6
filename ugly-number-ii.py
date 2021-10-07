class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n ==1:
            return 1
        dp=[0]*(n+1)
        dp[0]=1
        p2,p3,p5=0,0,0
        n2,n3,n5=2,3,5
        for i in range(1,n+1):
            minVal=min((n2*dp[p2]),(n3*dp[p3]),(n5*dp[p5]))
            dp[i]=minVal
            if(minVal ==(n2*dp[p2])):
                p2+=1
            if(minVal ==(n3*dp[p3])):
                p3+=1
            if(minVal ==(n5*dp[p5])):
                p5+=1
        return dp[n-1]