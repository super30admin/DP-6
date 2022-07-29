'''
Time Complexity: 0(n)
Space Complexity: 0(n)
Run on LeetCode: Yes
'''
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # initialize pointers
        p2 = 0 
        p3 = 0
        p5 = 0
        
        # initialize list
        uglyNumbers = [1]
        
        # list count 
        count = 1
        
        while count < n:          
            
            n2 = uglyNumbers[p2]*2
            n3 = uglyNumbers[p3]*3
            n5 = uglyNumbers[p5]*5
            
            # find the min
            minimum = min(n2,n3,n5)
            
            # append minimum
            uglyNumbers.append(minimum)
                    
            if minimum == n2:
                p2 += 1 
                
            if minimum == n3:
                p3 += 1
                
            if minimum == n5:
                p5 += 1
            
            # update count
            count += 1
            
        '''end of while loop'''
        print(uglyNumbers)
        return uglyNumbers[-1]