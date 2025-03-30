class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # T: O(n), S: O(n)
        # Initialize DP array to store ugly numbers
        ugly = [0] * n
        ugly[0] = 1  # 1 is the first ugly number

        # Pointers for multiplying with 2, 3, and 5
        p2 = p3 = p5 = 0

        # Next candidates for the next ugly number
        next_2 = 2
        next_3 = 3
        next_5 = 5

        # Fill in the array
        for i in range(1, n):
            # Get the minimum of the three candidates
            ugly[i] = min(next_2, next_3, next_5)

            # Update the pointers and next candidates accordingly
            if ugly[i] == next_2:
                p2 += 1
                next_2 = ugly[p2] * 2

            if ugly[i] == next_3:
                p3 += 1
                next_3 = ugly[p3] * 3

            if ugly[i] == next_5:
                p5 += 1
                next_5 = ugly[p5] * 5

        return ugly[n - 1]
