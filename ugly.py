# Time: O(n)
# Space: O(n)
# Did it run on Leetcode: yes

from Queue import PriorityQueue
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        # O(Nlogn)
        # hset = set()
        # pq = PriorityQueue()
        # pq.put(1)
        # hset.add(1)
        # count = 0
        # primes = [2, 3, 5]
        # curr=0
        # while count != n:
        #     curr = pq.get()
        #     count += 1
        #     for prime in primes:
        #         new_ugly = curr * prime
        #         if new_ugly not in hset:
        #             hset.add(new_ugly)
        #             pq.put(new_ugly)

        # return curr
        
        # O(n)
        arr=[0]*n
        arr[0]=1
        p2,p3,p5=0,0,0
        n2,n3,n5=2,3,5
        count=0
        for i in range(1,n):
            minval=min(n2,min(n3,n5))
            arr[i]=minval
            if(minval==n2):
                p2+=1
                n2=arr[p2]*2
            if(minval==n3):
                p3+=1
                n3=arr[p3]*3
            if(minval==n5):
                p5+=1
                n5=arr[p5]*5
        return arr[n-1]