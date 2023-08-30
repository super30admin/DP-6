# Time Complexity : O(n)
# Space Complexity :O(1)
# Passed on Leetcode: yes

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        # Initialize an array to store the ugly numbers
        ugly_numbers = [1]

        # Initialize pointers for 2, 3, and 5 multiples
        ptr2, ptr3, ptr5 = 0, 0, 0

        while len(ugly_numbers) < n:
            next_ugly = min(ugly_numbers[ptr2] * 2, ugly_numbers[ptr3] * 3, ugly_numbers[ptr5] * 5)

            # Add the next ugly number to the list
            ugly_numbers.append(next_ugly)

            # Update the pointers for multiples of 2, 3, and 5
            if next_ugly == ugly_numbers[ptr2] * 2:
                ptr2 += 1
            if next_ugly == ugly_numbers[ptr3] * 3:
                ptr3 += 1
            if next_ugly == ugly_numbers[ptr5] * 5:
                ptr5 += 1

        return ugly_numbers[-1]
