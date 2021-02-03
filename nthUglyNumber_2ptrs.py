"""
This is dp solution 
with 3 pointers you can handle duplicates as well as sorted order
get min between (n2,n3,n5) and increase that pointer and find new N2,n3,n5 by using existing val in the dp array * corresponding number 

TC=O(N)
SC=O(N)


"""

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [0 for _ in range(n+1)]
        dp[0] = 1
        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5

        for i in range(1, n+1):
            currmin = min(n2, n3, n5)
            dp[i] = currmin

            if currmin == n2:
                p2 += 1
                n2 = dp[p2]*2

            if currmin == n3:
                p3 += 1
                n3 = dp[p3]*3

            if currmin == n5:
                p5 += 1
                n5 = dp[p5]*5

        return dp[n-1]