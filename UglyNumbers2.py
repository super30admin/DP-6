#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        lst=[0]*n
        lst[0]=1
        n2,n3,n5=2,3,5
        p2,p3,p5=0,0,0
        for i in range(1,len(lst)):
            mini=min(n2,n3,n5)
            lst[i]=mini
            if mini==n2:
                p2+=1
                n2=lst[p2]*2
            if mini==n3:
                p3+=1
                n3=lst[p3]*3
            if mini==n5:
                p5+=1
                n5=lst[p5]*5
        return lst[-1]
        