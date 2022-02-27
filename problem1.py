# Time complexity: O(n)
# Space Complexity : O(n)

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1

        arr = [1]
        n1 = 2
        n2 = 3
        n3 = 5
        p1 = 0
        p2 = 0
        p3 = 0

        while len(arr) < n:
            _min = min(n1, n2, n3)

            arr.append(_min)

            if n1 == _min:
                p1 += 1
                n1 = 2 * arr[p1]

            if n2 == _min:
                p2 += 1
                n2 = 3 * arr[p2]

            if n3 == _min:
                p3 += 1
                n3 = 5 * arr[p3]

        return arr[-1]




