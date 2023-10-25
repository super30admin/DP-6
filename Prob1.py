class Solution:
    def nthUglyNumber(self, n: int) -> int:
        #Method 1 - Check each number till you get n ugly number -> O(n^2)
        #Method 2 - Use min heap - start with 1, pop it mul it with 2,3,5 and them back in, pop 2 mul it with 2,3,5 and so on till count==n. 
        #TC - O(NlogN) and SC O(N)

        # seen=set() #seen to avoid dupliates.
        # curr=1
        # uglynum=[1]
        # seen.add(1)
        # primes=[2,3,5]
        # count=0
        # while count!=n:
        #     curr=heapq.heappop(uglynum)
        #     count+=1
        #     for prime in primes:
        #         next_ugly =curr*prime
        #         if next_ugly not in seen:
        #             seen.add(next_ugly)
        #             heapq.heappush(uglynum, next_ugly)
        # return curr

        #Method 3 - Pointer simulation of heap
        #TC and SC- O(n)
        l=[0 for _ in range(n+1)]
        l[0]=1
        p2=p3=p5=0
        n2=2
        n3=3
        n5=5
        for i in range(1,n+1):
            min_num=min(n2,n3,n5)
            l[i]=min_num
            if n2==min_num: #here it's all ifs and not if else block cause if more than 1 of them produce same minimum number to get rid of duplicates increment both the pointers
                p2+=1
                n2=2*l[p2]
            if n3==min_num:
                p3+=1
                n3=3*l[p3]
            if n5==min_num:
                p5+=1
                n5=5*l[p5]
        return l[n-1]
