class Solution:
    def nthUglyNumber(self, n: int) -> int:
        '''
        Time: O(nlogn)
        Space: O(n)
        '''
        import heapq
        x = set([1])
        hp = [1]
        max1 = 1
        j=1
        z = [2,3,5]
        while(j<=n):
            h  = heapq.heappop(hp)
            j+=1
            if(h>max1):
                max1 = h
            for i in z:
                if(not i*h in x):
                    heapq.heappush(hp,i*h)
                    x.add(i*h)
        
        return max1
