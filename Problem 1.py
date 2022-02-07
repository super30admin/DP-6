# Space: O(n)
# Time: O(n)
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ans = [-1]*n
        # Pointers
        p2 = 0
        p3 = 0
        p5 = 0
        
        # Future vals
        n2 = 2
        n3 = 3
        n5 = 5
        ans[0] = 1
        
        for i in range(1, n):
            #print(i)
            mn = min(n2, min(n3, n5))
            ans[i] = mn
            if i == n-1:
                break
            if mn == n2:
                p2 += 1
                n2 = 2 * ans[p2]
            if mn == n3:
                p3 += 1
                n3 = 3 * ans[p3]
            if mn == n5:
                p5 += 1
                n5 = 5 * ans[p5]
        #print(ans)
        return ans[n-1]
            
        
        
