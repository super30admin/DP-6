# Time Complexity : O(n)
# Space Complexity: O(n)

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        res = [0 for _ in range(n)]
        res[0] = 1
        p2 = 0
        p3 = 0
        p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        for i in range(1, n):
            # print(res)
            min_val = min(n2, min(n3, n5))
            res[i] = min_val
            if min_val == n2:
                p2 += 1
                n2 = res[p2]*2
            if min_val == n3:
                p3 += 1
                n3 = res[p3]*3
            if min_val == n5:
                p5 += 1
                n5 = res[p5]*5

        return res[n-1]

#         visited = set()
#         nums = []
#         heapq.heapify(nums)
#         heapq.heappush(nums, 1)
#         visited.add(1)
#         out = []
#         count = 0
#         while count < n:
#             val = heapq.heappop(nums)
#             out.append(val)
#             count += 1
#             for i in [2,3,5]:
#                 new = val * i
#                 if new not in visited:
#                     heapq.heappush(nums, new)
#                     visited.add(new)
#         print(out)
#         return out[-1]
