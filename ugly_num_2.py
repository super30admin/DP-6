# Time: O(n)
# Space: O(n)

class Solution(object):
    def nthUglyNumber(self, n):
        n2, n3, n5 = 2, 3, 5
        p2, p3, p5 = 0, 0, 0
        arr = [1] 
        while len(arr) < n:
            minN = min(n2, n3, n5)
            arr.append(minN)

            if minN == n2:
                p2 += 1
                n2 = arr[p2] * 2
            if minN == n3:
                p3 += 1
                n3 = arr[p3] * 3
            if minN == n5:
                p5 += 1
                n5 = arr[p5] * 5

        return arr[-1]
