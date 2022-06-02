#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        li = [1]
        p2 = 0
        p5 = 0
        p3 = 0
        
        for i in range(1,n):
            li.append( min(2*li[p2],min(3*li[p3],5*li[p5])))
            if li[i] == 2*li[p2]:
                p2 +=1
            if li[i] == 3*li[p3]:
                p3 +=1
            if li[i] == 5*li[p5]:
                p5 +=1
                
        return li[-1]
                
            