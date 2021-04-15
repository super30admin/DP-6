#Time complexity:O(n)
#Space Complexity:O(n)
#Approach: use 3 pointers for 2, 3 and 5 each. Let n2, n3 and n5 hold the ugly numbers with 2, 3 and 5 as primes respectively.Use an arry to 
#hld all n ugly numbers, get the minimum between n2, n3 and n5 and insert it into the array. if miminum matches either n2,n3 or n5, increment
#the respective pointer by one and update the number n2, n3 or n5 with 2 3 or 5 respectively. Return the last number in the ugly array at the end.
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        if n==1:
            return 1
        ugly=[0 for i in range(n)]
        ugly[0]=1
        p2=0
        p3=0
        p5=0
        n2=2
        n3=3
        n5=5
        for i in range(1,n):
            minimum=min(n2,n3,n5)
            ugly[i]=minimum
            if n2==minimum:
                p2+=1
                n2=ugly[p2]*2
            if n3==minimum:
                p3+=1
                n3=ugly[p3]*3
            if n5==minimum:
                p5+=1
                n5=ugly[p5]*5
        return ugly[-1]