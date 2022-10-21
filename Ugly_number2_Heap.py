# Time complexity : O(n log K)
# Space complexity : O(n)
# Leetcode : Solved and submitted

import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # if the number is 1, then return 1
        if n == 1:
            return 1
        
        # maintain a set to check the visited numbers
        seen = set()
        
        # add the first number to the set and heap
        minHeap = [1]
        seen.add(1)
        
        # create a primes array of number 2,3,5
        primes = [2, 3, 5]
        
        # traverse until the n is not zero
        while n != 0:
            
            # pop the element from the heap
            curr = heapq.heappop(minHeap)
            
            # multiply the number with all the primes, and add it to the set if not already present
            for prime in primes:
                newNum = curr*prime
                if newNum not in seen:
                    heapq.heappush(minHeap, newNum)
                    seen.add(newNum)
            n -= 1
        # return the last number recieved
        return curr
