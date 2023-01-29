# Time Complexity : O(n), Where n is the input
# Space Complexity : O(n), Where n is the input
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        #Edge Case
        if(n==1):
            return 1
        
         #Here we will use a list to store the all the "n" ugly numbers
        u_list=[1]
        n_picked=1
        #Here we will have three pointers for pointing 
        p2=0
        p3=0
        p5=0
        
        n2=2
        n3=3
        n5=5
        while(n_picked!=n):
            value=min(n2,n3,n5)#First find the minimum among the n2,n3,n5
            u_list.append(value)
            
            if(value==n2):
                p2+=1#Increment the p2
                n2=2*u_list[p2]#New value at n2
            if(value==n3):
                p3+=1#Incremet the p3
                n3=3*u_list[p3]#New value at n3
            if(value==n5):
                p5+=1#Increment the p5
                n5=5*u_list[p5]#New value at p5
            n_picked+=1
        return u_list[n_picked-1]