class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res = [1]
        c2, c3, c5 = 0, 0, 0
        
        while n > 1:
            n2 = res[c2]*2
            n3 = res[c3]*3
            n5 = res[c5]*5
            minVal = min(n2, n3, n5)
            if n2 == minVal:
                c2 += 1
            if n3 == minVal:
                c3 += 1
            if n5 == minVal:
                c5 += 1
            res.append(minVal)
            n -= 1
        return res[-1]

            
