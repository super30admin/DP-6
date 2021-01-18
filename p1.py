#Heap Solution
#Time: O(NlogN)
#Space: O(N)

from heapq import heappush as insert
from heapq import heappop as remove


class Solution:
    def nthUglyNumber(self, n: int) -> int:

        
        if (n == 1):
            return n

      
        minHeap = [1]
        visited = set([1])
        count = 0
        primes = [2, 3, 5]
        poppedElement = 1

       
        while (count < n):

            
            popped = remove(minHeap)
            count += 1

            
            for prime in primes:

                nextElement = popped * prime

                if (nextElement not in visited):
                    visited.add(nextElement)
                    insert(minHeap, nextElement)

        
        return popped




#3 pointers soultion
#Time: O(N)
#Space: O(N)

class Solution:
    def nthUglyNumber(self, n: int) -> int:

       
        if (n == 1):
            return n

        
       res = [1]

       
        i2 = 0
        i3 = 0
        i5 = 0
        count = 1

        
        while (count < n):

            
            nextValue = min(res[i2] * 2, res[i3] * 3, res[i5] * 5)
            res.append(nextValue)

            
            if (res[count] == res[i2] * 2):
                i2 += 1

            if (res[count] == res[i3] * 3):
                i3 += 1

            if (res[count] == res[i5] * 5):
                i5 += 1

           
            count += 1

       
        return res[n - 1]
