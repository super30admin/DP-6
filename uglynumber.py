class Solution:
    
    """
    Description: given an integer, return the nth ugly number (a number whose prime factors are 2, 3 or 5)
    
    Time Complexity: O(n log n) using heap, O(n) using dp solution
    Space Complexity: O(n) for both approaches
    
    Approach: using heap
    - knowing the fact that any ugly number is multiple of either 2, 3 or 5, start with number = 1
    - create a heap initializing with value = 1, and a set to avoid repeats (2*3 = 3*2 etc.)
    - in each iteration starting from 0 until n - 1, pop the heap to get minimum ugly number
    - get a list of numbers by multiplying with 2, 3 and 5
    - update set and heap with condition, and return the min value from the heap
    
    Approach: using dp:
    - initiate a dp array starting with value 1, have 3 indices starting at 0
    - from nums array [2, 3, 5], pick index of the minimum value as minimum index, and value as next ugly number
    - append the dp array and identify, the minimum indices for each 2, 3 and 5 in dp array
    - multiply dp array's value at the minimum index to modify nums array
    - return the last found ugly number as answer
    """

    def nthUglyNumber(self, n: int) -> int:
        
        dp = [1]; next_ugly = 1
        index_2, index_3, index_5 = (0, 0, 0)
        nums = [2, 3, 5]
        ind_min = nums.index(min(nums))
        
        for i in range(1, n):
            
            next_ugly = min(nums)
            ind_min = nums.index(next_ugly)
            
            dp.append(next_ugly)
            min_idx_list = [k for k, value in enumerate(nums) if value == next_ugly]
            
            for ind_min in min_idx_list:
                if ind_min == 0: 
                    index_2 += 1
                    nums[ind_min] = 2*dp[index_2]
                elif ind_min == 1: 
                    index_3 += 1
                    nums[ind_min] = 3*dp[index_3]
                elif ind_min == 2: 
                    index_5 += 1
                    nums[ind_min] = 5*dp[index_5]
                    
        return next_ugly 

            
    from heapq import heappush, heappop, heapify
    
    def nthUglyNumber(self, n: int) -> int:
        
        count = 0; pq = [1] 
        
        # convert pq as heap
        heapify(pq)
        
        numSet = {1}; nums = [2, 3, 5]
        
        while count < n:
            
            ugly = heappop(pq)
            temp_list = [ugly*num for num in nums]
            
            # update heap and set
            for value in temp_list:
                if not value in numSet:
                    heappush(pq, value)
                    numSet.add(value)
                    
            count += 1
            
        return ugly
