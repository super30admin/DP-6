#Time Complexity : O(n)
#Space Complexity : O(n) 
#Did this code successfully run on Leetcode : Yes

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
             return 1
        arr = [0 for _ in range(n+1)]
        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5

        for i in range(1, n+1):
            mini = min(n2, n3, n5)
            arr[i] = mini
            if mini == n2:
                p2 += 1
                n2 = arr[p2]*2
            if mini == n3:
                p3 += 1
                n3 = arr[p3]*3
            if mini == n5:
                p5 += 1
                n5 = arr[p5]*5

        return arr[n-1]
