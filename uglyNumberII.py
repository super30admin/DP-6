class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p2 = p3 = p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        arr = [1]
        for i in range(1, n):
            minNum = min(n2, n3, n5)
            arr.append(minNum)
            if n2 == minNum:
                p2+=1
                n2 = 2*arr[p2]
            if n3 == minNum:
                p3+=1
                n3 = 3*arr[p3]
            if n5 == minNum:
                p5+=1
                n5 = 5*arr[p5]
        return arr[-1]