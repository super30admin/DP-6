""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ans = [0] * n

        p2, p3, p5 = 0, 0, 0
        n2 = 2
        n3 = 3
        n5 = 5
        ans[0] = 1
        for i in range(1, n):
            mini = min(n2, n3, n5)
            ans[i] = mini
            if (mini == n2):
                p2 += 1
                n2 = 2 * ans[p2]

            if (mini == n3):
                p3 += 1
                n3 = 3 * ans[p3]

            if (mini == n5):
                p5 += 1
                n5 = 5 * ans[p5]
        return ans[-1]




# class Solution:
#     def nthUglyNumber(self, n: int) -> int:
#         h=[]
#         hset=set()
#         heapq.heappush(h, 1)
#         hset.add(1)
#         primes=[2,3,5]
#         count=0

#         while count<n:

#             curr=heapq.heappop(h)
#             count+=1
#             for i in primes:
#                 newnum=curr*i
#                 if newnum not in hset:
#                     hset.add(newnum)
#                     heapq.heappush(h, newnum)

#         return curr




