#TC:O(n),n=1690-->O(1)
#SC:O(n),n=1690-->O(1)
#Ran successfullly on Leetcode:yes
#Approach:Use three pointers to generate the numbers with factors 2,3,5. Select the min among them and add them to the array of ugly number. Once the length of the array of ugly numbers reach n, we return the nth ugly number.
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        number=[]
        i=0
        j=0
        k=0
        number.append(1)
        while len(number)<n:
            # print(number[0])
            temp1=number[i]*2
            # print(temp1)
            temp2=number[j]*3
            # print(temp2)
            temp3=number[k]*5
            # print(temp3)
            minNum=min(temp1,temp2,temp3)
            number.append(minNum)
            if minNum==temp1:
                i+=1
            if minNum==temp2:
                j+=1
            if minNum==temp3:
                k+=1
        print(number)
        return number[-1]
                
