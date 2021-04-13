# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n == 1:
            return 1
        
        arr = [0 for i in range(n)]
        arr[0] = 1
        p2 = p3 = p5 = 0
        n2 = 2
        n3 = 3
        n5 = 5
        for i in range(1,n):
            mn = min(n2, n3, n5)
            arr[i] = mn
            if n2 == mn:
                p2 += 1
                n2 = arr[p2]*2
                
            if n3 == mn:
                p3+=1
                n3  = arr[p3]*3
            if n5 == mn:
                p5 += 1
                n5 = arr[p5]*5
        
        return arr[-1]