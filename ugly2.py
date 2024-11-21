"""
Time: O(n)
Space:O(n)
Leet: Accepted
Problems: Could not come up with Solution had to refer leetcode Solution
"""
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        ugly = [1] #initiate array
        ptr2=ptr3=ptr5=0 #maintain 3 pointers

        for i in range(1,n):
            u2,u3,u5 = 2*ugly[ptr2], 3*ugly[ptr3], 5*ugly[ptr5] #derive the 3 next possible values
            nex = min(u2,u3,u5)
            ugly.append(nex) #append the correct one

            #increment whichever pointer is appended
            if u2 == nex:
                ptr2 += 1
            if u3 == nex:
                ptr3 += 1
            if u5 == nex:
                ptr5 += 1

        return ugly[-1]
