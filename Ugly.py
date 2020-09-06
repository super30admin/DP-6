import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly=1
        set1=set()
        set1.add(ugly)
        h=[]
        heapq.heappush(h,ugly)
        primes=[2,3,5]
        i=0
        while i<n:
            ugly=heapq.heappop(h)
            for p in primes:
                calculated=p*ugly
                if calculated not in set1:
                    set1.add(calculated)
                    heapq.heappush(h,calculated)
            i+=1
        return ugly
    
        
#Time complexity is O(nlogn)
#Space is O(n)
