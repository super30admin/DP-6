#Time -> O(n)
#Space -> O(n)

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n==1:
            return 1
        
        n2,n3,n5=2,3,5
        result=[1]*n
        p2,p3,p5=0,0,0
        
        for i in range(1,n):
            my_min=min(n2,n3,n5)
            result[i]=my_min
            
            if n2==my_min:
                p2+=1
                n2=2*result[p2]
            
            if n3==my_min:
                p3+=1
                n3=3*result[p3]
            
            if n5==my_min:
                p5+=1
                n5=5*result[p5]
                
        
        return result[n-1]