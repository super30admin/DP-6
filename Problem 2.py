# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No



class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = [1]
        # index with with thh num needs to be mutiplied with ugly
        i2, i3, i5 = 0, 0, 0
        nos = 1

        while nos < n:
            # find the next 3 ugly numbers
            n2, n3, n5 = 2 * ugly[i2], 3 * ugly[i3], 5 * ugly[i5]
            # find the min ugly number, append to the list and increase the index of multiplication
            num = min(n2, n3, n5)
            ugly.append(num)

            if num == n2:
                i2 += 1
            if num == n3:
                i3 += 1
            if num == n5:
                i5 += 1
            nos += 1
        # return last element of ugly
        return ugly[-1]