# Problem 2: Ugly Number II
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        prime = [2,3,5]
        added = set()
        minHeap = []
        currUgly = 1

        heapq.heappush(minHeap,1)
        added.add(1)
        while n > 0:
            n -= 1
            
            currUgly = heapq.heappop(minHeap)
            for pr in prime:
                newUgly = pr * currUgly

                if newUgly not in added:
                    added.add(newUgly)
                    heapq.heappush(minHeap,newUgly)

        return currUgly



