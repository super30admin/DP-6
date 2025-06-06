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
