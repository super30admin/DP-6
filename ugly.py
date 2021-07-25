class Solution:
    def nthUglyNumber(self, n: int) -> int:

        primenumber = [2, 3, 5]
        ugly, heap = 1, []
        occurance_hashset = set()
        occurance_hashset.add(1)

        heapq.heappush(heap, ugly)

        for id in range(n):
            ugly = heapq.heappop(heap)
            for pr in primenumber:
                newygly = ugly * pr
                if newygly not in occurance_hashset:
                    heapq.heappush(heap, newygly)
                    occurance_hashset.add(newygly)
        return ugly


class Solution:
    def nthUglyNumber(self, n: int) -> int:

        dp = [0] * n
        dp.insert(0, 1)

        primenumber = [2, 3, 5]

        p1, p2, p3 = 0, 0, 0
        n1, n2, n3 = 2, 3, 5

        for idx in range(1, n):

            minnumber = min(dp[p1] * n1, min(dp[p2] * n2, dp[p3] * n3))

            # dp.insert(idx,minnumber)
            dp[idx] = minnumber

            if minnumber == dp[p1] * n1:
                p1 += 1
            if minnumber == dp[p2] * n2:
                p2 += 1
            if minnumber == dp[p3] * n3:
                p3 += 1
        print(dp)

        return dp[n - 1]

#         primenumber =[2,3,5]
#         ugly , heap = 1, []
#         occurance_hashset = set()
#         occurance_hashset.add(1)

#         heapq.heappush(heap, ugly)

#         for id in range(n):
#             ugly = heapq.heappop(heap)
#             for pr in primenumber:
#                 newygly = ugly * pr
#                 if newygly not in occurance_hashset:
#                     heapq.heappush(heap, newygly)
#                     occurance_hashset.add(newygly)


#         print (occurance_hashset)
#         return ugly

