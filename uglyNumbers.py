#To solve this problem we use 3 pointer approach
#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        arr = [0 for i in range(n+1)]
        arr[0] = 1
        p2 = 0
        p3 = 0
        p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        for i in range(1,n+1):
            miin = min(n2, min(n3,n5))
            arr[i] = miin
            if miin == n2:
                p2 += 1
                n2 = arr[p2] * 2
            if miin == n3:
                p3 += 1
                n3 = arr[p3] * 3
            if miin == n2:
                p5 += 1
                n5 = arr[p5] * 5
        return arr[n-1]
        