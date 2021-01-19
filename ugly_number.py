class Solution:
    def nthUglyNumber(self, n: int) -> int:
        #####hashset and heap#########
        ## hashset for non repeating elements and heap for sorting
        ## time - O(nlogn)
        ## space - O(n)
        # from queue import PriorityQueue
        # q=PriorityQueue()
        # q.put(1)
        # s=set()
        # s.add(1)
        # primes={2,3,5}
        # for i in range(n-1):
        #     ugly=q.get()
        #     for prime in primes:
        #         if ugly*prime not in s:
        #             s.add(ugly*prime)
        #             q.put(ugly*prime)
        # return q.get()

        ######## 3 pointer######
        ##time - O(n)
        ##space - O(n)
        ## take the min element from n2,n3,n5 and increase the corresponding pointer by 1 and multiply with arr[p]*corresponding n value

        arr = [0] * (n)
        arr[0] = 1
        p2 = 0
        p3 = 0
        p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        for i in range(1, n):
            mini = min(n2, min(n3, n5))
            arr[i] = mini
            if mini == n2:
                p2 += 1
                n2 = 2 * arr[p2]
            if mini == n3:
                p3 += 1
                n3 = 3 * arr[p3]
            if mini == n5:
                p5 += 1
                n5 = 5 * arr[p5]
        return arr[-1]