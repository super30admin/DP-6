# Time Complexity: O(n log m) - where m is the total number of generated unique ugly numbers (> n),
# Space Complexity: O(m)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        pq = [1]
        seen = set([1])
        primes = [2, 3, 5]

        while n > 0:
            curr = heapq.heappop(pq)
            n -= 1
            for p in primes:
                new_ugly = curr * p
                if new_ugly not in seen:
                    heapq.heappush(pq, new_ugly)
                    seen.add(new_ugly)
        
        return curr