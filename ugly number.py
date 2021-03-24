"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
if we multiply 1,2,3,5 with each other and then with results then we will
get ugly numbers. Using the DFS we can find such numbers by kepping on multiplying with the recurring results


METHOD 1: heap : 
1. use SET for unique numbers
2. use heap for getting the lowest numbers

METHOD 2: using pointers
take three pointers and 3 numbers n2,n3,n5
create res array
put the min out of n2,n3,n5 inside the res
update the pointer corresponding to the min number by 1
which were initially at 0


"""
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p5,p2,p3 = 0,0,0
        n2,n3,n5 = 2,3,5
        index = 1
        arr = [0]*n
        arr[0] = 1
        
        for i in range(1, n):
            mn = min(n2,n3,n5)
            arr[i] = mn
            
            if mn == n2:
                p2 += 1
                n2 = arr[p2]*2
            
            if mn == n3:
                p3 += 1
                n3 = arr[p3]*3
            
            if mn == n5:
                p5 += 1
                n5 = arr[p5]*5
            index += 1
        print(arr)
        return arr[n-1]
              
class Solution1:
    def nthUglyNumber(self, n: int) -> int:
        st = set()
        heap = []
        heapq.heappush(heap, 1)
        st.add(1)
        ar = [2,3,5]
        count = 1
        while True:
            
            x = heapq.heappop(heap)
            count += 1
            if count == n+1:
                return x
            for i in ar:
                t = x*i
                if t not in st:
                    st.add(t)
                    heapq.heappush(heap,t)
        return -1
                    