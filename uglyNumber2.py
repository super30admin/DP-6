class Solution:
    # dp approach
    # TC : O(n)
    # SC : O(n)
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        dp = [0]*n
        dp[0] = 1
        p2,p3,p5 = 0,0,0
        n2,n3,n5 = 2,3,5
        for i in range(1,n):
            dp[i] = min(n2,min(n3,n5))
            if dp[i] == n2:
                p2 += 1
                n2 = dp[p2] * 2
            if dp[i] == n3:
                p3 += 1
                n3 = dp[p3] * 3
            if dp[i] == n5:
                p5 += 1
                n5 = dp[p5] * 5
        return dp[n-1]
