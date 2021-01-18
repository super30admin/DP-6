#3 pointers soultion
#Time: O(N)
#Space: O(N)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res = [1]
        p2, p3 , p5 = 0,0,0
        for i in range(n):
            temp = min(2*res[p2],3*res[p3],5*res[p5])
            res.append(temp)
            if temp == 2*res[p2]:
                p2+=1
            if temp == 3*res[p3]:
                p3+=1
            if temp == 5*res[p5]:
                p5+=1
                
        return res[n-1]
            
        
        
'''
#Time: O(NlogN)
#Space: O(N)

from heapq import heappush as insert
from heapq import heappop as remove

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        hashset = set()
        heap = []
        insert(heap, 1)
        hashset.add(1)
        for i in range(n-1):
            ele = remove(heap)
            n2 = ele * 2
            n3 = ele * 3
            n5 = ele * 5
            if n2 not in hashset:
                insert(heap, n2)
                hashset.add(n2)
            if n3 not in hashset:
                insert(heap, n3)
                hashset.add(n3)
            if n5 not in hashset:
                insert(heap, n5)
                hashset.add(n5)
        
        
        return remove(heap)

'''
