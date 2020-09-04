# Time Complexity : O(mxn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# TC = O(nlogn) | O(n) space
# import heapq 
# class Solution:
#     def nthUglyNumber(self, n: int) -> int:
#         if n == 0:
#             return 0 
#         st = []
#         hashset = set()
#         hashset.add(1)
#         pq = []
#         heapq.heappush(pq,1)
#         while len(st) < n:
#             curr = heapq.heappop(pq)
#             st.append(curr) 
#             for num in [2,3,5]:
#                 calc = num * curr 
#                 if calc not in hashset:
#                     heapq.heappush(pq, calc)
#                     hashset.add(calc)
#         print(st)
#         return st[n-1]
        
# Tc = O(n) | Sc = O(1)
class Solution:
    def nthUglyNumber(self, n):
        if n == 0:
            return 0 
        st = [1]
        p2, p3, p5 = 0, 0, 0 
        n2, n3, n5 = 2, 3, 5
        
        for i in range(1, n):
            min_ = min(n2, n3, n5)
            st.append(min_)
            
            if min_ == n2:
                p2 += 1 
                n2 = st[p2] * 2 
            
            if min_ == n3:
                p3 += 1 
                n3 = st[p3] * 3 
            
            if min_ == n5:
                p5 += 1 
                n5 = st[p5] * 5 
        
        return st[n-1]      

if __name__ == "__main__":
    s = Solution()
    res = s.nthUglyNumber(10)
    assert res == 12  