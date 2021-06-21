class Solution:
    #DP sol
    def nthUglyNumber(self, n: int) -> int:
        
        if not n:
            return 0
        
        dp = [0] * n
        dp[0] = 1
        
        p2,p3,p5 = 0,0,0
        n2,n3,n5 = 2,3,5
        
        for i in range(1,n):
            minval = min(dp[p2]*n2,dp[p3]*n3, dp[p5]*n5)            
            dp[i] = minval
            if minval == dp[p2]*n2:
                p2 +=1
            if minval == dp[p3]*n3:
                p3 +=1
            if minval == dp[p5]*n5:
                p5 +=1
        
        return dp[-1]
         
    
    
    #PQ + hashset
    def nthUglyNumber_(self, n: int) -> int:
        
        if not n:
            return 0
        
        s = set()  
        heap = []
        prime = [2,3,5]
        ugly = 1   
        s.add(ugly)
        heap.append(ugly)
        
        for i in range(1,n+1):
            #print(heap)
            ugly = heappop(heap)
            for num in prime:
                if ugly*num not in s:
                    s.add(ugly*num)
                    heappush(heap,ugly*num)        
        
        return ugly 
