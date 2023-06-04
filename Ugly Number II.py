# Time Complexity :  O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = [1]
        p2 = p3 = p5 = 0
        for i in range(1,n):
            u2 = 2*ugly[p2]
            u3 = 3*ugly[p3]
            u5 = 5*ugly[p5]

            u = min(u2,u3,u5)
            ugly.append(u)

            if u == u2:
                p2 += 1
            if u == u3:
                p3 += 1
            if u == u5:
                p5 += 1
        return ugly[n-1]