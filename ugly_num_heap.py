class Solution:
    def nthUglyNumber(self, n: int) -> int:
        """
        TC:O(nlogn)
        SC:O(n) for heap and set
        """
        heap = []
        heapq.heappush(heap, 1)
        sett = set()
        sett.add(1)
        uglys = [2, 3, 5]
        count = 0
        for i in range(1, n):
            curnum = heapq.heappop(heap)
            print(curnum)
            for u in uglys:
                num = curnum*u
                if num not in sett:
                    sett.add(num)
                    heapq.heappush(heap, num)
                    if len(heap) == n:
                        break
        return heapq.heappop(heap)
