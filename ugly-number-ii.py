# DP SOLUTION
# TIME COMPLEXITY: O(n)
# SPACE COMPLEXITY: O(n)
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp = [0 for _ in range(n+1)]
        dp[0] = 1
        ptr2, ptr3, ptr5 = 0, 0, 0
        num2, num3, num5 = 2, 3, 5

        for i in range(1, len(dp)):
            curr_min = min(num2, num3, num5)
            dp[i] = curr_min

            if curr_min == num2:
                ptr2 += 1
                num2 = dp[ptr2]*2

            if curr_min == num3:
                ptr3 += 1
                num3 = dp[ptr3]*3

            if curr_min == num5:
                ptr5 += 1
                num5 = dp[ptr5]*5

        return dp[n-1]
