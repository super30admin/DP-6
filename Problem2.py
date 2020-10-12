#Time complexity : O(n)
#Space complexity: O(n)
#Works on leetcode : yes
#Approach : Since the ugly numbers are only multiple of 2,3,5 we start with 1 and one by one multiply the 1 with 2,3 and 5
#Each time we take minimum of the multiples from 2,3,5 and add it to the ugly number list. Also we increment pointer respective
#to 2,3,5 based on the minimum

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        ugly = [1]
        i2,i3,i5 = 0,0,0
        while n>1:
            u2,u3,u5 = 2*ugly[i2], 3*ugly[i3], 5*ugly[i5]
            umin = min((u2,u3,u5))
            if umin==u2:
                i2 +=1
            if umin==u3:
                i3 +=1
            if umin==u5:
                i5 +=1
            ugly.append(umin)
            n -=1
        return ugly[-1]