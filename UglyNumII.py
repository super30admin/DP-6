#All TC passed on leetcode


class Solution:
    def nthUglyNumber(self, n: int) -> int:

         #Here we start with 3 pointers p1,p2,p3 pointing at index 0 and 3 nums n2,n3,n5 with 2,3,5 as initial nums. 
         #We iterate from 1 uptill n and find ugly num in each iteartion and add it to res. We take min of n2,n3,n5 and 
         #curMin's corresponding pointer is incremented. curMin's new value is computed by multiplying val at its position with 2/3/5.
        #time complexity - O(n) 
        #space complexity - O(n) - where n length array used to store ugly nums
        if n==1:
            return 1

        res = [0]*n
        res[0] = 1

        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5

        for i in range(1, n):
            curMin = min(n2,n3,n5)
            res[i] = curMin

            if n2==curMin:
                p2+=1
                n2 = 2*res[p2]
            
            if n3==curMin:
                p3+=1
                n3 = 3*res[p3]

            if n5==curMin:
                p5+=1
                n5 = 5*res[p5]
        
        return res[n-1]




#-------------------------------------------OR-----------------------------------------------------


        #Here we start with 1 and begin to explore next ugly nums by multiplying 2,3,5. These new ugly nums are added to minHeap and a set in order to avoid duplicates and maintain sorted order.
        #time complexity - O(nlogk) where k is less than n.
        #space complexity - O(n)

        if n==1:
            return 1

        minHeap = []
        nums = set()
        primes = [2,3,5]

        heapq.heappush(minHeap, 1)
        nums.add(1)
        n-=1
    
        while n>=0:
            cur = heapq.heappop(minHeap)
            n-=1
            for p in primes:
                val = p*cur
                if val not in nums:
                    heapq.heappush(minHeap, val)
                    nums.add(val)
        return cur                    

