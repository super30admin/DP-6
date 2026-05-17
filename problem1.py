# problem1

#https://leetcode.com/problems/ugly-number-ii/

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        min_heap = []
        heapq.heappush(min_heap,1)
        visited_set = set([1])
        prime_number = [2,3,5]
        for _ in range(n):
            val = heapq.heappop(min_heap)
            for p_number in prime_number:
                new_val = val*p_number 
                if new_val not in visited_set:
                    visited_set.add(new_val)
                    heapq.heappush(min_heap,new_val)
        return (val)