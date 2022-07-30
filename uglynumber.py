#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        p1,p2,p3 = 0,0,0
        n2,n3,n5 = 2,3,5
        nums = [0]*n
        nums[0] = 1
        
        for i in range(1,n):
            
            minm = min(n2,n3,n5)
            nums[i] = minm
            
            if minm == n2:
                p1+=1
                n2 = nums[p1]*2
                
            if minm == n3:
                p2+=1
                n3 = nums[p2]*3
                
            if minm == n5:
                p3+=1
                n5 = nums[p3]*5
                
            
        return nums[-1]
                
            
            
            
            