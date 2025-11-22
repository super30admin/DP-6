# Time Complexity : O(N) where N is the input number
# Space Complexity : O(N) where N is the size of the result list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using three pointers to keep track of the multiples of 2, 3, and 5.
# I initialize the result list with the first ugly number, which is 1.
# For each iteration, I calculate the next ugly number by taking the minimum of
# the next multiples of 2, 3, and 5.
# I then update the corresponding pointer(s) if the next ugly number was generated
# by that multiple.
# Finally, I return the nth ugly number from the result list.

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        result = [1]
        i2,i3,i5 = 0,0,0
        for i in range(1,n):
            num = min(result[i2] * 2 ,result[i3]*3,result[i5]*5)
            result.append(num)
            if num == result[i2] *2:
                i2 += 1
            if num == result[i3] *3:
                i3 += 1         
            if num == result[i5] *5:
                i5 += 1
        return result[n-1]
            
