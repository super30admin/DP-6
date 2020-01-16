'''
Accepted on leetcode(264)
time - O(N)
space - O(N)
'''


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [1]

        # declare 3 pointers
        i2, i3, i5 = 0, 0, 0

        iterate
        n
        times.
        while n > 1:
            # calculate u2, u3 and u5 and take the min among them and add that to dp array. Then compare the minimum with u2, u3 and u5 whichever is minimum increase that pointer by 1.
            u2 = 2 * dp[i2]
            u3 = 3 * dp[i3]
            u5 = 5 * dp[i5]

            umin = min(u2, u3, u5)

            if umin == u2:
                i2 += 1
            if umin == u3:
                i3 += 1
            if umin == u5:
                i5 += 1

            dp.append(umin)
            n -= 1
        # return last element in dp array
        return dp[-1]