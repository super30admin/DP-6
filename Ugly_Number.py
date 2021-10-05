#Space:O(n)
#Time:O(nlogk)
import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        processed =set()
        
        if n==1:
            return 1
        
        primes = [2,3,5]
        
        heap = []
        # heap = heapq()
        heapq.heappush(heap, 1)
        
        processed.add(1)
        
        count = 0
        while(heap):
            val = heapq.heappop(heap)
            count+=1
            if count == n:
                return val
            for prime in primes:
                if val*prime not in processed:
                    heapq.heappush(heap, val*prime)
                    processed.add(val*prime)
        