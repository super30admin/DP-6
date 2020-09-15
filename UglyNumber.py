'''
Solution:
1.  First solution is using min heap, where after 1, pop the min element from the heap and process with all 3 primes,
    The new values are pushed into heap if they aren't already occurred. The nth popped element from min heap would be
    the nth ugly number.
2.  Second solution is to maintain 3 pointers and consider the next ugly number as the minimum of numbers at respective
    pointer indices times respective primes. The nth number to be filled in the final array would be nth ugly number.

Time Complexity:    O(NlogK) for first solution where k is the average size of min heap
                    O(N) for second solution
Space Complexity:   O(K) for first solution where k is the average size of min heap
                    O(N) for second solution
--- Passed all testcases successfully for both the solutions on leetcode.
'''

from heapq import heappush as insert
from heapq import heappop as remove


class UglyHeap:
    def nthUglyNumber(self, n: int) -> int:

        #   edge case check
        if (n == 1):
            return n

        #   initializations
        minHeap = [1]
        visited = set([1])
        count = 0
        primes = [2, 3, 5]
        poppedElement = 1

        #   iterate until nth ugly number
        while (count < n):

            #   remove min element from min heap
            poppedElement = remove(minHeap)
            count += 1

            #   for each of the primes, mutlipy min element and push into heap if not in the hash set
            for prime in primes:

                nextElement = poppedElement * prime

                if (nextElement not in visited):
                    visited.add(nextElement)
                    insert(minHeap, nextElement)

        #   return the nth popped element from min heap
        return poppedElement


class UglyPointers:
    def nthUglyNumber(self, n: int) -> int:

        #   edge case check
        if (n == 1):
            return n

        #   initializations -- start with 1
        finalResult = [1]

        #   initializations -- put all 3 pointers at index = 0
        i2 = 0
        i3 = 0
        i5 = 0
        count = 1

        #   move the pointers until nth ugly number is reached
        while (count < n):

            #   next ugly number is the minimum of numbers at respective pointer indices times respective primes
            nextValue = min(finalResult[i2] * 2, finalResult[i3] * 3, finalResult[i5] * 5)
            finalResult.append(nextValue)

            #   if next ugly number is equivalent to any of the 3 results, move that pointer forward
            if (finalResult[count] == finalResult[i2] * 2):
                i2 += 1

            if (finalResult[count] == finalResult[i3] * 3):
                i3 += 1

            if (finalResult[count] == finalResult[i5] * 5):
                i5 += 1

            #   increment count
            count += 1

        #   return nth ugly number
        return finalResult[n - 1]