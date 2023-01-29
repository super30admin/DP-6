class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ## approach 2
        ## T.C = O(n)
        ## S.C = O(n)

        res = [0]*n
        res[0] = 1
        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5

        for i in range(1, n):
            mn = min(n2, n3, n5)
            res[i] = mn
            if mn == n2:
                p2 += 1
                n2 = 2 * res[p2]
            if mn == n3:
                p3 += 1
                n3 = 3 * res[p3]
            if mn == n5:
                p5 += 1
                n5 = 5 * res[p5]

        return res[-1]
            
        ## approach 1
        ## T.C = O(n.logk)
        ## S.C = O(m)

        hs = set()

        nums = [2,3,5]
        counter = 0
        q = [1]
        heapq.heapify(q)
        hs.add(1)
        curr_num = 0

        while counter < n:
            curr_num = heapq.heappop(q)
            for i in nums:
                tmp = curr_num * i
                if tmp not in hs:
                    hs.add(tmp)
                    heapq.heappush(q, tmp)
            
            counter += 1
        
        return curr_num