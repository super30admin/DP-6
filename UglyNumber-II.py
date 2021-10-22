"""
Time Complexity : O(n) where n is the number given 
Space Complexity : O(n) where n is the number given 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        result = [0]*n
        result[0] = 1
        p2 = p3 = p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        # We initialize 3 pointers for 2, 3, 5 and then traverse through all numbers
        # and move the pointers accordingly on which no. is minimum prime factor
        # At the end we rreturn the last element in the result array
        for i in range(1, n):
            mini = min(n2, n3, n5)
            result[i] = mini
            if mini == n2:
                p2 += 1
                n2 = 2 * result[p2]
            if mini == n3:
                p3 += 1
                n3 = 3 * result[p3]
            if mini == n5:
                p5 += 1
                n5 = 5 * result[p5]
        return result[n - 1]