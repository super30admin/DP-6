class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # Hashset and heap solution
        # Time O(nlogn)
        # Space O(n)


        # num = [2,3,5]
        # li = []
        # numset = set()
        # # dq = deque()
        # # dq.append(1)
        # heapq.heapify(li)
        # heapq.heappush(li,1)
        # while n > 0:
        #     n -= 1
        #     curr = heapq.heappop(li)
        #     numset.add(curr)
        #     for i in num:
        #         if (curr*i) not in numset:
        #             heapq.heappush(li, curr*i)
        #             numset.add(curr*i)
        # res = sorted(list(numset))
        # print(res)
        # print(numset)
        # return curr

        # Optimised solution
        # Time O(n)
        # Space O(n)
        p0,p1,p2 = 0,0,0
        n2,n3,n5 = 2,3,5
        li = [0] * n
        li[0] = 1
        for i in range(1,n):
            li[i] = min(li[p0]*2, li[p1]*3, li[p2]*5)
            if li[p0]*2==li[i]:p0+=1
            if li[p1]*3==li[i]:p1+=1
            if li[p2]*5==li[i]:p2+=1
        return li[n-1]
