# Time:-O(n)
# Space:- O(n)
# Approach:- The ugly number should be a multiple of 2 or 3 or 5 and these should be the only prime factors 
# it must have, if it has any other prime factor then it is not an ugly number. So we can make this ugly
# bumber list using the multiples of 2,3,5. The numbers in the ugly numbers list are the only ones which 
# contribute to this list. 
class Solution:
    def nthUglyNumber(self, n: int) -> int:
        res=[1]
        i,j,k=0,0,0
        while(len(res)<n):
            num=min(2*res[i],3*res[j],5*res[k])
            if num>res[-1]:
                res.append(num)
            # 2 has contributed an ugly number to the list increment 2's pointer
            if 2*res[i]==num:
                i+=1
            # 3 has contributed an ugly number to the list increment 3's pointer
            if 3*res[j]==num:
                j+=1
            # 5 has contributed an ugly number to the list increment 5's pointer
            if 5*res[k]==num:
                k+=1
        return res[-1]
                