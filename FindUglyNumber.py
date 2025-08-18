import heapq
# class Solution:
#     def nthUglyNumber(self, n: int) -> int:
#         pq = [1]
#         seen = set([1])
#         primefactors = [2,3,5]
#         while n>0:
#             curr = heapq.heappop(pq)
#             n-=1
#             for p in primefactors:
#                 newugly=curr*p
#                 if newugly not in seen:
#                     seen.add(newugly)
#                     heapq.heappush(pq, newugly)
#         return curr

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        arr = [0]*n
        p2=p3=p5=0
        n2,n3,n5=2,3,5
        arr[0] = 1
        for i in range(1,n):
            arr[i] = min(n2,min(n3,n5))
            if arr[i] == n2:
                p2+=1
                n2=arr[p2]*2
            if arr[i] == n3:
                p3+=1
                n3=arr[p3]*3
            if arr[i] == n5:
                p5+=1
                n5 = arr[p5]*5
        return arr[n-1]

