# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ugly = [1]
        i2, i3, i5 = 0, 0, 0
        while (len(ugly) < n):
            next_ugly = (min((ugly[i2] * 2), (ugly[i3] * 3), (ugly[i5] * 5)))
            ugly.append(next_ugly)
            if next_ugly == (ugly[i2] * 2):
                i2 += 1
            if next_ugly == (ugly[i3] * 3):
                i3 += 1
            if next_ugly == (ugly[i5] * 5):
                i5 += 1
        return ugly[-1]