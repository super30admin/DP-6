import heapq


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        """
            Time Complexity - O(nlogn)
            Space Complexity - O(n)
        """
        pq = [1]
        visited = set([1])
        i = 1
        while i < n:
            cur_num = heapq.heappop(pq)
            for num in [2, 3, 5]:
                num *= cur_num
                if num not in visited:
                    heapq.heappush(pq, num)
                    visited.add(num)
            i += 1
        return heapq.heappop(pq)

    def nthUglyNumber(self, n: int) -> int:
        """
            Time Complexity - O(n)
            Space Complexity - O(1)
        """
        p2 = p3 = p5 = 0
        n2, n3, n5 = 2, 3, 5
        arr = [1]
        while len(arr) < n:
            cur_min = min(n2, n3, n5)
            arr.append(cur_min)
            if cur_min == n2:
                p2 += 1
                n2 = arr[p2] * 2
            if cur_min == n3:
                p3 += 1
                n3 = arr[p3] * 3
            if cur_min == n5:
                p5 += 1
                n5 = arr[p5] * 5
        return arr[n - 1]


if __name__ == '__main__':
    print(Solution().nthUglyNumber(10))
