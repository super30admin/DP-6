"""
Time: O(nlogn)
Space: O(n)
Leet: Accepted
Problems: None
"""

from collections import Counter
class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]

        nums.sort()
        counter = Counter(nums) #maintain count of numbers
        new_nums = [0] * (nums[-1]+1)

        #new_nums will hold value added if that number is chosen at the respective index
        for key in counter:
            new_nums[key] = key*counter[key]

        dp = [0] * len(new_nums)
        dp[0] = new_nums[0]
        dp[1] = max(new_nums[0],new_nums[1])

        #solve it exactly like house robber Problem
        for i in range(2,len(dp)):
            dp[i] = max(dp[i-1],dp[i-2]+new_nums[i])

        return dp[-1]
