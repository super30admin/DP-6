class Solution:
    def nthUglyNumber(self, n: int) -> int:
        heap = []
        factors = [2, 3, 5]
        heapq.heappush(heap, 1)
        visited = set()
        visited.add(1)

        while n > 1:
            cur = heapq.heappop(heap)

            for factor in factors:
                temp = cur * factor 
                
                if temp not in visited:
                    heapq.heappush(heap, temp)
                    visited.add(temp)
            n -= 1
        
        # print(heap)
        return heapq.heappop(heap)
                
                


