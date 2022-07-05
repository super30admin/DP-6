#Ugly number 2

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp=[0]*n
        dp[0]=1
        p2=p3=p5=0                          #pointers for the indices
        n2=2                                #the prime numbers 
        n3=3
        n5=5
        for i in range(1, n):
            mini = min(n2,n3,n5)            #every loop, find the minimum number and then increment their pointer and change the number depending on the value
            if mini==n2:
                dp[i] = mini
                p2+=1
                n2 = 2*dp[p2]
            if mini==n3:
                dp[i] = mini
                p3+=1
                n3 = 3*dp[p3]
                
            if mini==n5:
                dp[i] = mini
                p5+=1
                n5 = 5*dp[p5]
        print(dp)
        return dp[-1]