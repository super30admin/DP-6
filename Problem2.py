class Solution:
    def nthUglyNumber(self, n: int) -> int:
        arr = [0] * n
        arr[0] = 1
        p2 = 0
        p3=0
        p5= 0
        n2 = 2
        n3=3
        n5= 5
        for i in range(1,n):
            minn = min(n2, min(n3,n5))
            arr[i] = minn
            if minn == n2:
                p2+=1
                n2 = 2*arr[p2]
            if minn == n3:
                p3+=1
                n3 = 3*arr[p3]
            if minn == n5:
                p5+=1
                n5 = 5*arr[p5]

        return arr[n-1]


        