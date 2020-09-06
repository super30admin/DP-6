"""
time : o(n)
space : o(n)

"""
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        res = [0] * n
        res[0] = 1 #first ugly number is one
        
        p2, p3, p5 = 0, 0, 0 #3 ptrs maintaining position for each of the numbers
        n2, n3, n5 = 2, 3, 5 #values to be considered at each point
        
        for i in range(1,n):
            min_val = min(n2, n3, n5) #find the min val at a certain point
            res[i] = min_val
           
            if n2 == min_val: #according the min value, increment the corresponding pointers and update the numbers for the next iteration
                p2 += 1
                n2 = res[p2] * 2
            
            if n3 == min_val:
                p3 += 1
                n3 = res[p3] * 3
            
            if n5 == min_val:
                p5 += 1
                n5 = res[p5] * 5

        return res[-1] #the last number will be the nth ugly number