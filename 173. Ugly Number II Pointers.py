class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        n2 = 2
        n3 = 3
        n5 = 5
        p2 = 0
        p3 = 0
        p5 = 0
        minimum = 1
        result = [0] * n
        result[0] = 1
        for i in range(1, n):
            minimum = min(n2, min(n3, n5))
            result[i] = minimum
            if minimum == n2:
                p2 += 1
                n2 = result[p2] * 2

            if minimum == n3:
                p3 += 1
                n3 = result[p3] * 3

            if minimum == n5:
                p5 += 1
                n5 = result[p5] * 5
        # print(result)
        return result[-1]

# Pointers
# Time Complexity:O(n)
# Space Complexity: (n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No