#time- nlogk, k is the elements inside pq , space-n elements inside hashset
import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        nums=[2,3,5]
        heap=[]
        heapq.heappush(heap,1)
        hset=set()
        hset.add(1)
        count=0
        while count<n:
            temp=heapq.heappop(heap)
            count+=1
            for num in nums:
                ugly=temp*num
                if ugly not in hset:
                    heapq.heappush(heap,ugly)
                    hset.add(ugly)
                    
        
            
            
        return temp
        