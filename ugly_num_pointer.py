class Solution:
    def nthUglyNumber(self, n: int) -> int:
        """
        TC:O(n)
        SC:O(n) 
        """
        res = [0 for i in range(n)]
        res[0] = 1
        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5

        for i in range(1, n):
            curmin = min(n2, n3, n5)
            res[i] = curmin
            if curmin == n2:
                p2 += 1
                n2 = res[p2]*2
            if curmin == n3:
                p3 += 1
                n3 = res[p3]*3
            if curmin == n5:
                p5 += 1
                n5 = res[p5]*5

        return res[n-1]
