# Time complexity : O(n)
# Space complexity : O(n)
# Leetcode : Solved and submitted

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # return 1 if the number is 1
        if n == 1:
            return 1
        
        # create an array of ugly numbers
        arr = [1]
        
        # start the pointers from 0 and numbers as the value itself
        p2, p3, p5 = 0, 0, 0
        n2, n3, n5 = 2, 3, 5
        
        # traverse for all numbers
        for i in range(n):
            # find the min_val among the numbers n2, n3, n5
            min_val = min(n2, min(n3, n5))
            
            # append the min_val to the arr
            arr.append(min_val)
            
            # if n2 was the min, then increment the p2 pointer and update the n2 with 2 * the new number at index p2
            if n2 == min_val:
                p2 += 1
                n2 = 2 * arr[p2]
                
            # if n3 was the min, then increment the p3 pointer and update the n3 with 3 * the new number at index p3
            if n3 == min_val:
                p3 += 1
                n3 = 3* arr[p3]
            
            # if n5 was the min, then increment the p5 pointer and update the n5 with 5 * the new number at index p5
            if n5 == min_val:
                p5 += 1
                n5 = 5 * arr[p5]
        
        # return the last value in the arr
        return arr[n-1]
