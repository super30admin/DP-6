# Time Complexity : O(n)
# Space Complexity : O(n)

# Code ran on LeetCode
# Mintain 3 pointers for 2, 3, and 5. At each step, add the minimum number we can get from the three pointers to the result. Increment the corresponding pointer by 1

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        result = [1]*n
        p2 = p3 = p5 = 0
        n2 = 2; n3 = 3; n5 = 5
        for i in range(1, n):
            m = min(n2, n3, n5)
            result[i] = m
            if n2 == m:
                p2 += 1
                n2 = result[p2]*2
            if n3 == m:
                p3 += 1
                n3 = result[p3]*3
            if n5 == m:
                p5 += 1
                n5 = result[p5]*5
        return result[n-1]