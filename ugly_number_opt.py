#time-n space-1
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p2=0
        p3=0
        p5=0
        n2=2
        n3=3
        n5=5
        result=[]
        result.append(1)
        count=1
        while count<n:
            
            m=min(n2,n3,n5)
            
            result.append(m)
            if m==n2:
                p2+=1
                n2=result[p2]*2
            if m==n3:
                p3+=1
                n3=result[p3]*3
            if m==n5:
                p5+=1
                n5=result[p5]*5
            count+=1
        return result[-1]
            