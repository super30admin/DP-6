"""
Problem1: (https://leetcode.com/problems/ugly-number-ii/)
"""

# Approach - 1

from queue import PriorityQueue
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        """
        creating new nums from the primes. Using priority queue for sorting the numbers and hashset to avoid repeated num.
        TC: O(nlogK) n num given and K the size of priority queue
        SC O(logK)
        """
        pq = PriorityQueue()
        primes = [1,2,3,5]
        already_created = set()
        pq.put(1)
        already_created.add(1)
        newNum = 0
        while n !=0 :
            curr = pq.get()
            n -= 1
            
            for prime in primes:
                newNum = curr*prime
                if newNum not in already_created:
                    pq.put(newNum)
                    already_created.add(newNum)
                    
            
        
        return curr
                    

# Approach - 2 

from queue import PriorityQueue
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        """
        Using three pointers for 2, 3, 5 and keeping the new numbers in res array
        TC:O(N)
        SC:O(N)
        """
        #taking three pointers for the three prime numbers
        p2 , p3, p5 = 0, 0 ,0
        
        n2, n3, n5  = 2, 3 ,5
        
        # initializing the result array which will keep all the possible numbers from 2,3,5
        res = [0 for _ in range(n)]
        res[0] = 1
        
        for i in range(1, n):
            min_value = min(n2, min(n3,n5))
            res[i] = min_value
            
            if n2 == min_value:
                            p2 += 1
                            n2 = 2 * res[p2]
                            
            if n3 == min_value:
                            p3 += 1
                            n3 = 3 * res[p3]
                            
            if n5 == min_value:
                            p5 += 1
                            n5 = 5 * res[p5]
                            
        return res[-1]
                            
                            
        
                    
        
           
        