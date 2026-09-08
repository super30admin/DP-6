# Problem1: (https://leetcode.com/problems/ugly-number-ii/)
# Time Complexity: O(n),We loop once from index 1 to n-1 and each iteration does only O(1) work(comparing three numbers and maybe updating a pointer), so total work is O(n)
# Space Complexity: O(n),We use an array arr of size n to store every ugly number from the 1st to the nth
# Approach:
# An ugly number is any number whose only prime factors are 2, 3, and 5 so every ugly number can be built by taking a smaller ugly number and multiplying it by 2, 3, or 5
# We build the array of ugly numbers in sorted order using tabulation (bottom up DP)
# We keep three pointers p2, p3, p5 which tell us which ugly number in arr should be multiplied by 2, 3, or 5 next to produce a new candidate
# At each step we take the smallest of the three candidates as the next ugly number then we advance the pointer(s) whose candidate was just used, this avoids generating the same ugly number twice and keeps everything in sorted order

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        arr = [0]*n     # arr will store the first n ugly numbers in increasing order
        arr[0]=1        # the first ugly number is always 1 by definition

        # p2, p3, p5 are indices into arr, they point to the ugly number
        # that should next be multiplied by 2, 3, and 5 respectively
        p2,p3,p5 = 0,0,0

        # n2, n3, n5 are the actual candidate values, this is arr[p2]*2, arr[p3]*3, arr[p5]*5
        # we start them at 2,3,5 since arr[0] is 1 and 1*2=2, 1*3=3, 1*5=5
        n2,n3,n5 = 2,3,5

        # we already filled index 0, so we build the rest from index 1 to n-1
        for i in range(1,n):
            # the next ugly number is the smallest of the three candidates
            # this guarantees we always produce numbers in sorted order
            arr[i]= min(n2,min(n3,n5))

            # if the candidate from the "times 2" pointer was used, move that pointer forward
            # and recompute its next candidate using the new arr[p2]
            if arr[i]==n2:
                p2 +=1
                n2 = arr[p2]*2

            # same idea for the "times 3" pointer
            # this is a separate if, not elif, because a number can be reached by
            # more than one path, for example 6 = 2*3 = 3*2, so multiple pointers
            # can match the same value and all of them need to advance to avoid duplicates
            if arr[i] == n3:
                p3 += 1
                n3 = arr[p3] * 3

            # same idea for the "times 5" pointer
            if arr[i] == n5:
                p5 += 1
                n5 = arr[p5] * 5

        # the nth ugly number is at index n-1 since arr is 0 indexed
        return arr[n - 1]