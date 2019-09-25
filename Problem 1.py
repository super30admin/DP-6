# Time Complexity : O(n) where n is length of nums
# Space Complexity :O(n) where n is length of nums
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

import collections
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return nums[0]
        # made dictionary of occurances of all the number
        points = collections.Counter(nums)
        prev = 0
        curr = 0

        # iterating till the maximum number present in the dictionary
        for n in range(max(points.keys()) + 1):
            # updating the prev to the simultaneous index and updating curr to the max points value
            prev, curr = curr, max(prev + points[n] * n, curr)

        return curr