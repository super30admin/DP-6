# Using heap
# Time Complexity: O(n * log(n))
# Space Complexity: O(n)
import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        count = 1
        currUgly = 1
        minheap = []
        aset = set()
        heapq.heappush(minheap, currUgly)
        primes = [2, 3, 5]   
        while count <= n:
            currUgly = heapq.heappop(minheap)
            count += 1
            for prime in primes:
                newUgly = prime * currUgly
                if newUgly not in aset:
                    heapq.heappush(minheap, newUgly)
                    aset.add(newUgly)
        return currUgly

# Without Using heap
# Time Complexity: O(n)
# Space Complexity: O(n)

import heapq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5
        result = [0] * n
        result[0] = 1
        for i in range(1, n):
            mini = min(n2, n3, n5)
            result[i] = mini
            if mini == n2:
                p2 += 1
                n2 = result[p2] * 2
            if mini == n3:
                p3 += 1
                n3 = result[p3] * 3
            if mini == n5:
                p5 += 1
                n5 = result[p5] * 5
            
        return result[n-1]

