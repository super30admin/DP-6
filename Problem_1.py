"""
Time Complexity : O(n) for DP solution and O(nlogn) for heap solution
Space Complexity : O(n) for DP solution as we have an array and O(n) for heap as we are maintaining a hashset and a heap
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
I have implemented 2 solutions here. One with heap and hashset (commented) and another one with just an array. So, for using
heap, we just calculate the 3 possible numbers, check if they are present in hashset or not and if not, just push in the heap,
so that we get the minimum number everytime. This aaproach takes nlogn time because of the heap. This could be further
optimised if we use only an array(basically a 3 pointer approach).
"""


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res = [1]
        x2, x3, x5 = 0, 0, 0
        for i in range(n+1):
            temp = min(2*res[x2], 3*res[x3], 5*res[x5])
            res.append(temp)
            if temp == 2*res[x2]:
                x2 += 1
            if temp == 3*res[x3]:
                x3 += 1
            if temp == 5*res[x5]:
                x5 += 1
        return res[n-1]

# from heapq import heappush as insert
# from heapq import heappop as remove

# class Solution:
#     def nthUglyNumber(self, n: int) -> int:
#         hashset=set()
#         heap=[]
#         insert(heap,1)
#         hashset.add(1)
#         for i in range(n-1):
#             curr=remove(heap)
#             n2=2*curr
#             n3=3*curr
#             n5=5*curr
#             if n2 not in hashset:
#                 hashset.add(n2)
#                 insert(heap,n2)
#             if n3 not in hashset:
#                 hashset.add(n3)
#                 insert(heap,n3)
#             if n5 not in hashset:
#                 hashset.add(n5)
#                 insert(heap,n5)
#         return(remove(heap))
