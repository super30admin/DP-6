#starting the first element as 1 and then multiplying it with 2,3,5
#using heap and visited set to maintain duplicates and the sorting order
#time:O(n)
#space: O(n)
import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        visited=set()
        visited.add(1)
        heap=[1]
        for i in range(n):
            curr= heapq.heappop(heap)
            for p in [2,3,5]:
                new= curr*p
                if new not in visited:
                    visited.add(new)
                    heapq.heappush(heap,new)
        return curr
