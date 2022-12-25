from queue import PriorityQueue


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1

        hashSet = set()
        pq = PriorityQueue()
        pq.put(1)
        count = 0
        currUgly = 1
        primes = {2, 3, 5}
        while count < n:
            currUgly = pq.get()
            count += 1

            for prime in primes:
                newUgly = prime * currUgly
                if newUgly not in hashSet:
                    hashSet.add(newUgly)
                    pq.put(newUgly)

        return currUgly

#Brute Force Using Hashset for handling repeatability and Priority queue for sorting elements
# Time Complexity: O(nlogk) Adding in Priority Queue is logk and while loop is O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No