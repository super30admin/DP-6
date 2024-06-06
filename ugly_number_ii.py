# Time Complexity : O(n)
# Space Complexity : O(n)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        arr = [0]*n
        arr[0] = 1
        p2,p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5

        for i in range(1, n):
            minVal = min(n2, min(n3, n5))
            arr[i] = minVal
            if n2 == minVal:
                p2+=1
                n2 = arr[p2]*2
            if n3 == minVal:
                p3+=1
                n3 = arr[p3]*3
            if n5 == minVal:
                p5+=1
                n5 = arr[p5]*5
        
        return arr[n-1]