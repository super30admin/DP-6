'''
time complexity: O(n)
space complexity: o(n)
'''
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ans = [0 for _ in range(n)]
        
        p2,p3,p5 = 0,0,0
        n2 = 2
        n3 = 3
        n5 = 5
        ans[0]=1
        for i in range(1,n):
            mini = min(n2,n3,n5)
            ans[i] = mini
            if(mini == n2):
                p2+=1
                n2 = 2*ans[p2]
                
            if(mini == n3):
                p3+=1
                n3 = 3*ans[p3]
                
            if(mini == n5):
                p5+=1
                n5 = 5*ans[p5]
        return ans[-1]
        