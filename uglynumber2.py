# brute force solution
# Time complexity - O(n)
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n==1: return 1
        
        count = 1
        i = 2
        while count < n:
            num = i
            
            # check if the number is only divisible by 2, 3, and 5.
            while num%2==0:
                num//=2
            
            while num%3==0:
                num//=3
            
            while num%5==0:
                num//=5
                
            if num==1:
                count += 1
                
            i+=1
        return i-1
   
    
# Using heaps
# Time complexity - O(n logn) # priority queue
# Space complexity - O(1)
# Did this solution run on leetcode? - yes
import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        nums = []
        seen = set()                # keep track of the seen numbers.
        heapq.heappush(nums, 1)     
        
        i = 1
        while i<=n:
            ugly_num = heapq.heappop(nums)  # Push operation - O(1)
            
            # Find the next ugly numbers.
            num2 = ugly_num*2
            num3 = ugly_num*3
            num5 = ugly_num*5
            
            # check if the calculated numbers are not in the seen set, add to the heap and seen set.
            if num2 not in seen:
                heapq.heappush(nums, num2)  # Pop operation - O(log k)
                seen.add(num2)
            if num3 not in seen:
                heapq.heappush(nums, num3)
                seen.add(num3)
            if num5 not in seen:
                heapq.heappush(nums, num5)
                seen.add(num5)
                
            i+=1
            
        return ugly_num
    
    
# Using dynamic programming
# Time complexity - O(1)
# Space complexity - O(1) == to the result
# Did this solution run on leetcode? - yes
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        nums = [1,]
        
        idx2, idx3, idx5 = 0, 0, 0
        i=1
        
        while i<n:
            num2 = nums[idx2]*2
            num3 = nums[idx3]*3
            num5 = nums[idx5]*5
            
            # find the minimum value.
            minval = min(num2, num3, num5)
     
            """
            # Increment the pointers for 2,3 or 5.
            # No need to maintain the set
            # Since all the pointers that point to the current minimum will be incremented at once.
            """       
            if minval == num2:
                idx2 += 1
            if minval == num3:
                idx3 += 1
            if minval == num5:
                idx5 += 1
            
            # append the current minimum to the nums array.
            nums.append(minval)
            i+=1
        return nums[-1]
    