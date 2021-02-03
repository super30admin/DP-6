"""
minheap to get the order and set to handle duplicates.

TC=O(nLOGn) for Heap and SC=O(N) maintaining heap and set 
This is BF solution . Two pointers is optimal solution 
"""
import heapq 
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if(n==1):
            return 1
        numSet=set()
        pq=[]
        heapq.heappush(pq,1)
        numSet.add(1)
        primes=[2,3,5]
        for i in range(1,n):
            ugly=heapq.heappop(pq)
            for prime in primes:
                newUgly=prime*ugly
                if(newUgly not in numSet):
                    numSet.add(newUgly)
                    heapq.heappush(pq,newUgly)
        
        return(heapq.heappop(pq))