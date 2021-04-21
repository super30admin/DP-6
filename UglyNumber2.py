# Time Complexity : O(1)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using 3 pointers


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n < 2:
            return n
        arr = [0] * (n)
        arr[0] = 1
        p2 = 0
        p3 = 0
        p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        for i in range(1, n):
            minp = min(n2, n3, n5)
            arr[i] = minp
            if n2 == minp:
                p2 += 1
                n2 = arr[p2] * 2
            if n3 == minp:
                p3 += 1
                n3 = arr[p3] * 3
            if n5 == minp:
                p5 += 1
                n5 = arr[p5] * 5
        return arr[-1]