# Heap Solution
# TC O(nlogn)
# SC O(n)
import heapq as hq
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        heap, hset = [], set()
        hq.heappush(heap, 1)
        hset.add(1)
        primes = [2,3,5]
        count = 0
        
        while count < n:
            curr = hq.heappop(heap)
            count += 1
            for i in primes:
                newnum = curr*i
                if newnum not in hset:
                    hset.add(newnum)
                    hq.heappush(heap, newnum)
        return curr

# Linear Solution
# TC O(n)
# SC O(n)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res = [0] * n
        p2 = p3 = p5 = 0 # primes 2,3,5
        n2, n3, n5 = 2,3,5
        res[0] = 1
        for i in range(1,n):
            mini = min(n2,n3,n5)
            res[i] = mini
            if mini == n2:
                p2 += 1
                n2 = 2 * res[p2]
            
            if mini == n3:
                p3 += 1
                n3 = 3 * res[p3]
            
            if mini == n5:
                p5 += 1
                n5 = 5* res[p5]
        return res[-1]