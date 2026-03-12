# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# Ugly numbers are numbers whose only prime factors are 2, 3, and 5.
# Use dynamic programming with three pointers for multiples of 2, 3, and 5.
# At each step choose the minimum next ugly number and move the corresponding pointer(s).

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        ugly = [1]*n
        
        i2 = i3 = i5 = 0
        
        for i in range(1, n):
            
            next2 = ugly[i2]*2
            next3 = ugly[i3]*3
            next5 = ugly[i5]*5
            
            ugly[i] = min(next2, next3, next5)
            
            if ugly[i] == next2:
                i2 += 1
            if ugly[i] == next3:
                i3 += 1
            if ugly[i] == next5:
                i5 += 1
        
        return ugly[-1]